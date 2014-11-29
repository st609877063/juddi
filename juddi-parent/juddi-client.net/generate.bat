rem This will generate the client proxy code using the juddi wsdls and xsds via .NET 2.0 ASP.NET (System.Web.Services.WebClient)

set path=%path%;C:\Program Files (x86)\Microsoft SDKs\Windows\v8.0A\bin\NETFX 4.0 Tools


wsdl  ..\uddi-ws\src\main\resources\juddi_api_v1.wsdl ..\uddi-ws\src\main\resources\uddi_api_v3_binding.wsdl  ..\uddi-ws\src\main\resources\uddi_api_v3_portType.wsdl ..\uddi-ws\src\main\resources\uddi_custody_v3_binding.wsdl ..\uddi-ws\src\main\resources\uddi_custody_v3_portType.wsdl ..\uddi-ws\src\main\resources\uddi_repl_v3_binding.wsdl ..\uddi-ws\src\main\resources\uddi_repl_v3_portType.wsdl ..\uddi-ws\src\main\resources\uddi_subr_v3_binding.wsdl ..\uddi-ws\src\main\resources\uddi_subr_v3_portType.wsdl ..\uddi-ws\src\main\resources\uddi_sub_v3_binding.wsdl ..\uddi-ws\src\main\resources\uddi_sub_v3_portType.wsdl ..\uddi-ws\src\main\resources\uddi_v3_service.wsdl ..\uddi-ws\src\main\resources\uddi_vscache_v3_binding.wsdl ..\uddi-ws\src\main\resources\uddi_vscache_v3_portType.wsdl ..\uddi-ws\src\main\resources\uddi_vs_v3_binding.wsdl ..\uddi-ws\src\main\resources\uddi_vs_v3_portType.wsdl  ..\uddi-ws\src\main\resources\uddi_v3.xsd ..\uddi-ws\src\main\resources\uddi_v3custody.xsd ..\uddi-ws\src\main\resources\uddi_v3policy.xsd ..\uddi-ws\src\main\resources\uddi_v3policy_instanceParms.xsd ..\uddi-ws\src\main\resources\uddi_v3replication.xsd ..\uddi-ws\src\main\resources\uddi_v3subscription.xsd ..\uddi-ws\src\main\resources\uddi_v3subscriptionListener.xsd ..\uddi-ws\src\main\resources\uddi_v3valueset.xsd ..\uddi-ws\src\main\resources\uddi_v3valuesetcaching.xsd 

rem this is for the configuration file
xsd /c ..\juddi-client\src\main\resources\xsd\uddi-client.xsd /namespace:org.apache.juddi.v3.client.config 