<h4 align="center">SDET VIRTUOSO</h4>
<br>


# SeleniumMobSFBuildScanner
Selenium and Mobile Security Framework (MobSF) Integration to make Continuous Static Analysis possible.

## How to install MobSF in Docker
```
$ docker pull opensecurity/mobile-security-framework-mobsf
$ docker run -it -p 8000:8000 opensecurity/mobile-security-framework-mobsf:latest

or run this command instead:
$ docker-compose up -d

Then open your browser and navigate to http://localhost:8000/
```

## How to Run Mobile Static Analysis with Selenium
```
i.e Android Installer (.apk)
$ mvn clean test -Dtest=MobileStaticAnalysis -Durl="http://localhost:8000/" -Dpath="/Users/imostafa/Downloads/" -DapkName="security-dashboard.apk"
```

```
i.e iOS installer (.ipa)
$ mvn clean test -Dtest=MobileStaticAnalysis -Durl="http://localhost:8000/" -Dpath="/Users/imostafa/Downloads/" -DapkName="security-dashboard.ipa"
```

## References
- https://github.com/MobSF/Mobile-Security-Framework-MobSF
- https://www.selenium.dev/
