<div class="screenlet-body">
<form id="creategidopsEvent" method="post" action="<@ofbizUrl>creategidopsEvent</@ofbizUrl>">
<input type="hidden" name="inputdataftl" value="Y"/>
<fieldset>
<div>
<span class="label">${uiLabelMap.CustomerName}</span>
<input type="text" name="CustomerNametxt" id="CustomerNames" class='required' maxlength="100"/>
</div>
<div>
<span class="label">${uiLabelMap.RegNumber}</span>
<input type="text" name="RegNumbertxt" id="RegNumbers" class='required' maxlength="100"/>
</div>
<div>
<span class="label">${uiLabelMap.VehMakeModel}</span>
<input type="text" name="VehMakeModeltxt" id="VehMakeModels" class='required' maxlength="100"/>
</div>
<div>
<span class="label">${uiLabelMap.EngCapacity}</span>
<input type="text" name="EngCapacitytxt" id="EngCapacitys" class='required' maxlength="10"/>
</div>
<div>
<span class="label">${uiLabelMap.MVL}</span>
<input type="date" name="MVLtxt" id="MVLs" class='required' maxlength="20"/>
</div><br/>
<div>
<span class="label">${uiLabelMap.RWC}</span>
<input type="date" name="RWCtxt" id="RWCs"  maxlength="20"/>
</div><br/>
<div>
<span class="label">${uiLabelMap.INS}</span>
<input type="date" name="INStxt" id="INSs"  maxlength="20"/>
</div><br/>
<div>
<span class="label">${uiLabelMap.HKNY}</span>
<input type="date" name="HKNYtxt" id="HKNYs"  maxlength="20"/>
</div><br/>
<div>
<span class="label">${uiLabelMap.LGA}</span>
<input type="date" name="LGAtxt" id="LGAs"  maxlength="20"/>
</div><br/>
</fieldset>
<input type="submit" value="${uiLabelMap.Getitdone}"/>
</form>
</div>