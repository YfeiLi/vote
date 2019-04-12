drop procedure if exists updateRestVotes;
delimiter //
create procedure updateRestVotes()
  begin
    update activity_voter a
    set rest_votes = (
      select
        max_votes
      from vote_activity b
      where b.activity_id = a.activity_id
    )
    where activity_id in (
      select
        activity_id
      from vote_activity
      where votes_limit_type = 1
    );
  end;
//
delimiter ;

drop event if exists updateRestVotesTask;
create event updateRestVotesTask
  on schedule every 1 day starts date_add(curdate(), interval 1 day)
  on completion preserve enable
do call updateRestVotes();
