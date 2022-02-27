<h4 align="center">SDET VIRTUOSO</h4>
<br>


# SeleniumMobSFBuildScanner
Selenium and Mobile Security Framework (MobSF) Integration to make Continuous Static Build Analysis possible.

## How to install MobSF in Docker
```
$ docker pull opensecurity/mobile-security-framework-mobsf
$ docker run -it -p 8000:8000 opensecurity/mobile-security-framework-mobsf:latest

or run this command instead:
$ docker-compose up -d

Then open your browser and navigate to http://localhost:8000/
```

## How to Run Mobile Static Analysis with Maven
```
i.e Android Installer (.apk)
$ mvn clean test -Dtest=MobileStaticAnalysis -Durl="http://localhost:8000/" -Dpath="/Users/imostafa/Downloads/" -DbuildName="Security-Build.apk"
```

```
i.e iOS installer (.ipa)
$ mvn clean test -Dtest=MobileStaticAnalysis -Durl="http://localhost:8000/" -Dpath="/Users/imostafa/Downloads/" -DbuildName="Security-Build.ipa"
```

## How to Run Mobile Static Analysis with Gradle
```
i.e Android Installer (.apk)
$ gradle clean test -Durl="http://localhost:8000/" -Dpath="/Users/imostafa/Downloads/" -DbuildName="Security-Build.apk"
```

```
i.e iOS installer (.ipa)
$ gradle clean test -Durl="http://localhost:8000/" -Dpath="/Users/imostafa/Downloads/" -DbuildName="Security-Build.ipa"

```

## References
-[Mobile Security Framework (MobSF) Static Analysis](https://medium.com/@kshitishirke/mobile-security-framework-mobsf-static-analysis-df22fcdae46e)
- [Mobile-Security-Framework-MobSF](https://github.com/MobSF/Mobile-Security-Framework-MobSF)
- [Automate Using Selenium](https://www.selenium.dev/)
- [Docker Desktop Download](https://www.docker.com/products/docker-desktop)
- [GRADLE: TestNg - unable to pass -D parameter to java code](https://stackoverflow.com/questions/32815090/gradle-testng-unable-to-pass-d-parameter-to-java-code)
- [Pass parameters to gradle Java Demo](https://github.com/Opalo/stackoverflow/tree/master/32815090)
- [MobSF Docker Options](https://mobsf.github.io/docs/#/docker)
