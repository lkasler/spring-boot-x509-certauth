# X509 Client & Server based 2 way SSL communication based on CSR, CERT and
CA

## Example:

```
curl -ik --cert client.crt --key clientprivate.key "https://localhost:8443/cert?name=clint"
```

Type the client cert password: 'client'

Outpit is:

```
Enter PEM pass phrase:
HTTP/1.1 200
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
Strict-Transport-Security: max-age=31536000 ; includeSubDomains
X-Frame-Options: DENY
Content-Type: text/plain;charset=UTF-8
Content-Length: 20
Date: Fri, 28 Dec 2018 20:41:36 GMT

Cert demo, Hi clint!
```

