DROP FUNCTION IF EXISTS queryChildScope;
delimiter //
CREATE FUNCTION queryScopeRecursive(scopeId VARCHAR(4000))
  RETURNS VARCHAR(4000)
  BEGIN
    DECLARE sTemp VARCHAR(4000);
    DECLARE sTempChd VARCHAR(4000);

    SET sTemp='';
    SET sTempChd = CAST(scopeId AS CHAR);

    WHILE sTempChd IS NOT NULL DO
      SET sTemp= CONCAT(sTemp,',',sTempChd);
      SELECT GROUP_CONCAT(scope_id) INTO sTempChd FROM vote_scope WHERE FIND_IN_SET(scope_parent,sTempChd)>0;
    END WHILE;
    SET sTemp := SUBSTR(sTemp,2);
    RETURN sTemp;
  END;
//
delimiter ;
