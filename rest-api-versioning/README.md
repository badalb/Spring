REST API Versioning with URL :
http://localhost:8080/api/v1/greeting
http://localhost:8080/api/v2/greeting

REST API Versioning with ACCEPT Header:

HTTP Header
Content-Type	application/vnd.captech-v1.0+json
http://localhost:8080/greeting

HTTP Header
Content-Type	application/vnd.captech-v2.0+json
http://localhost:8080/greeting

REST API Versioning with CUSTOM Header:

Custom Header
X-Api-Version v1
http://localhost:8080/greeting

Custom Header
X-Api-Version  v2
http://localhost:8080/greeting