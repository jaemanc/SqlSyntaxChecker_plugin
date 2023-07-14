# SqlSyntaxChecker_plugin

intellij plug-in for checking grammar for simple query statements.


intellij version : IntelliJ IDEA 2022.3.3, build IU-223.8836.41. Copyright JetBrains s.r.o., (c) 2000-2023




## HOW TO USE?

Drag the query statement you want to examine and right-click it

<img width="1460" alt="image" src="https://github.com/jaemanc/SqlSyntaxChecker_plugin/assets/104718153/662de41e-a16f-42f1-924b-d15961fb242d">



Choose 'SQL syntax Check'



<img width="626" alt="image" src="https://github.com/jaemanc/SqlSyntaxChecker_plugin/assets/104718153/bc854059-2508-4d9a-83c6-c2bddbf3aa3d">



It determines if the query is appropriate.







## How do you determine if it's a suitable query?

### This plug-in is using jsqlparser.
Queries that are not parsed through jsqlparser are identified as error queries.
If you want to check the logic of determining the query, please visit the following site


## https://jsqlparser.github.io/JSqlParser/usage.html#parse-a-sql-statements



contact : jaemanc93@gmail.com
