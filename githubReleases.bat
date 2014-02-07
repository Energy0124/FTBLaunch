github-release release  --user Energy0124  --repo FTBLaunch  --tag %1  --name  "FTB Launcher SP %1"
launch4jc "build\launch4j\launch4j.xml"
cd "build\libs\"
for /f "usebackq delims=|" %%f in (`dir /b FTB_Launcher* ^| sort /r`) do (
echo %%f
github-release upload   --user Energy0124  --repo FTBLaunch  --tag %1  --name "%%f" --file  %%f
)
