# 多人共用記事本
## 環境建置
主框架：Spring boot 2.1.16.RELEASE
Maven version: Maven 4.0.0
Java version: 1.8
MongoDB server version: 4.2.1
DB: testblog
Table: blog

---
## 功能簡述

http://127.0.0.1:8081/User 可到User的個人記事頁
輸入完submit後會回到個人記事頁，上方會顯示所有屬於個人的記事項目

API：
- [POST] /api/blog/add 新增記事項目到 DB
- [GET] /api/blog/find/User 搜尋 User 的所有項目
- [GET] /all 顯示 blog 表中所有項目