insert into 
	wx_act_invite
      ( id,name,begain_time,end_time,hdurl) 
values
      ('${act.id}',
       :act.name,
       :act.begainTime,
	   :act.endTime,
   	   :act.hdurl
      )