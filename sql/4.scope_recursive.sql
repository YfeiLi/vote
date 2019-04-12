drop function if exists queryChildScope;
delimiter //
create function queryScopeRecursive(scopeId varchar(4000))
  returns varchar(4000)
  begin
    declare sTemp varchar(4000);
    declare sTempChd varchar(4000);

    set sTemp='';
    set sTempChd = cast(scopeId as char);

    while sTempChd is not null do
      set sTemp= concat(sTemp,',',sTempChd);
      select group_concat(scope_id) into sTempChd from vote_scope where find_in_set(scope_parent,sTempChd)>0;
    end while;
    set sTemp := substr(sTemp,2);
    return sTemp;
  end;
//
delimiter ;
