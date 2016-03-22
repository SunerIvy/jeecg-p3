UPDATE wx_act_invite 
SET 
	<#if act.id ?exists && act.id ?length gt 0>
	    id = :act.id
	</#if>
	<#if act.name ?exists && act.name ?length gt 0>
	    ,name = :act.name
	</#if>
	<#if act.begainTime ?exists>
	    ,begain_time = :act.begainTime
	</#if>
	<#if act.endTime ?exists>
	    ,end_time = :act.endTime
	</#if>
	<#if act.hdurl ?exists && act.hdurl ?length gt 0>
		,hdurl = :act.hdurl
	</#if>
WHERE id = :act.id