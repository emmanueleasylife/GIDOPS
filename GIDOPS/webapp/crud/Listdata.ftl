<div class="screenlet-body">
<#if listdatay?has_content>
<table cellspacing=0 cellpadding=2 border=0 class=basic-table>
   <thead>
   <tr>
   <th>${uiLabelMap.UniqueID}</th>
   <th>${uiLabelMap.CustomerName}</th>
   <th>${uiLabelMap.RegNumber}</th>
   <th>${uiLabelMap.VehMakeModel}</th>
   <th>${uiLabelMap.EngCapacity}</th>
   <th>${uiLabelMap.MVL}</th>
   <th>${uiLabelMap.RWC}</th>
   <th>${uiLabelMap.INS}</th>
   <th>${uiLabelMap.HKNY}</th>
   <th>${uiLabelMap.LGA}</th>
   </tr>
   </thead>
   <tbody>
   <#list listdatay as gidopsdata>
   <tr>
    <td>${gidopsdata.UniqueID}</td>
    <td>${gidopsdata.CustomerName?default("NA")}</td>
    <td>${gidopsdata.RegNumber?default("NA")}</td>
    <td>${gidopsdata.VehMakeModel?default("NA")}</td>
    <td>${gidopsdata.EngCapacity?default("NA")}</td>
    <td>${gidopsdata.MVL?default("NA")}</td>
    <td>${gidopsdata.RWC?default("NA")}</td>
    <td>${gidopsdata.INS?default("NA")}</td>
     <td>${gidopsdata.HKNY?default("NA")}</td>
    <td>${gidopsdata.LGA?default("NA")}</td>
   </tr>
   </#list>
   </tbody>
</table>
</#if>
</div>