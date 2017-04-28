<div class="screenlet-body">
<form id="createfilterEvent" method="post" action="<@ofbizUrl>createfilterEvent</@ofbizUrl>">
<input type="hidden" name="adddataftl" value="Y"/>
<fieldset>
<div>
<span class="label">${uiLabelMap.Sear}</span>
<select name="myoption">
<option>choose...</option>
<option value="A">All</option>
<option value="W">This Week</option>
<option value="M">This Month</option>
</select>
</div><br/>
</fieldset>
<input type="submit" value="${uiLabelMap.Getitdone}"/>
</form>
</div>