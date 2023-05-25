# ProtectingWebAppsAgainsXSSAndSQLi
A web application for banking is protected against SQL injection (SQLi) and Cross Site Scripting (XSS) attacks using policy based proxy server.

/BankApplication : is a normal banking application which is not shielded against SQLi and XSS attacks

/BankApplication_secure : uses a proxy server which receives every requests and detects whether a request is likely to cause XSS or SQLi attack. If yes, such request is either terminated or sanitized before sending it to the main server. Other requests are forwarded to the main server.
