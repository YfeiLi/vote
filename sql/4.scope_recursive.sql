drop function if exists queryChildScopeRecursive;
delimiter //
create function queryChildScopeRecursive(scopeId varchar(4000))
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

drop function if exists queryParentScopeRecursive;
delimiter //
create function queryParentScopeRecursive(scopeId varchar(4000))
  returns varchar(4000)
  begin
    declare sTemp varchar(4000);
    declare sTempChd varchar(4000);

    set sTemp='';
    set sTempChd = cast(scopeId as char);

    while sTempChd is not null do
      set sTemp= concat(sTemp,',',sTempChd);
      select group_concat(scope_parent) into sTempChd from vote_scope where find_in_set(scope_id,sTempChd)>0;
    end while;
    set sTemp := substr(sTemp,2);
    return sTemp;
  end;
//
delimiter ;
