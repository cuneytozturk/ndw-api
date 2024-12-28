keytool  -import -alias myalias -keystore  "C:\Users\june8\OneDrive\Documents\school\stagecap\tool" -file data.ndw.nu.crt
cd C:\Program Files\Java\jdk-17
"C:\Program Files\Java\jdk-17\bin\keytool.exe" -genkeypair -alias myalias -keystore mykeystore.jks -keyalg RSA -keysize 2048 -validity 365
password(default): changeit
yes


keytool -genkeypair -alias myalias -keystore mykeystore.jks -keyalg RSA -keysize 2048 -validity 365

test roadsectionid:
329419005
601131516

TODO:
OpenAPI
caching
yaml properties