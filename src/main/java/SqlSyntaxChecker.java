import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import org.apache.commons.lang3.ObjectUtils;

public class SqlSyntaxChecker extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project currentProject = event.getProject();

        DataContext dataContext = event.getDataContext();
        Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        if (editor != null) {
            SelectionModel selectionModel = editor.getSelectionModel();

            if (ObjectUtils.isEmpty(selectionModel.getSelectedText())) {
                Messages.showMessageDialog(currentProject, "Please block the sentence to check the query syntax", "Not Verifiable Statement", Messages.getInformationIcon());
                return;
            }

            String selectedText = selectionModel.getSelectedText();
            selectedText = selectedText.trim();
            if (selectedText.startsWith("\"")) {
                selectedText = selectedText.substring(0,1);
            }
            try {
                CCJSqlParserUtil.parse(selectedText);
                Messages.showMessageDialog(currentProject, selectedText, "AVAILABLE", Messages.getInformationIcon());
            } catch( JSQLParserException jsqlParserException) {
                String errors = jsqlParserException.getMessage();
                errors = errors.substring(errors.indexOf("Was expecting one of:"));

                Messages.showMessageDialog(currentProject,selectedText + System.lineSeparator() + System.lineSeparator() + errors, "NOT AVAILABLE" , Messages.getInformationIcon());
            } catch ( Exception t) {
                Messages.showMessageDialog(currentProject, selectedText + System.lineSeparator()+ t.getMessage(), "SORRY PLUGIN ERROR ㅜ_ㅜ" , Messages.getInformationIcon());
            }
        }
    }
}
