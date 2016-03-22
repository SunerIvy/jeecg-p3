insert into 
	wx_act_invite
      ( id,name,begin_time,end_time,hdurl) 
values
      ('${act.id}',
       :act.name,
       :act.beginTime,
	   :act.endTime,
   	   :act.hdurl
      )