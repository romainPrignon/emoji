FROM mcr.microsoft.com/dotnet/sdk:5.0 AS build
WORKDIR /src
COPY . .
RUN dotnet restore
RUN dotnet publish -c release -o /opt --no-restore

FROM mcr.microsoft.com/dotnet/runtime:5.0
WORKDIR /opt
COPY --from=build /opt .
ENTRYPOINT ["dotnet", "main.dll"]