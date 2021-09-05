FROM fsharp:netcore AS build
WORKDIR /src
COPY . .
RUN dotnet restore
RUN dotnet publish -c release -o /opt --no-restore

FROM fsharp:netcore
WORKDIR /opt
COPY --from=build /opt .
COPY main.runtimeconfig.json /opt/main.runtimeconfig.json
ENTRYPOINT ["dotnet", "main.exe"]