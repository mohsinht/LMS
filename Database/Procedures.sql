use LMS
go

create procedure


create procedure SearchByName
@nam varchar(30)
as
begin
	select * from Book where  [Name] = @nam  
end
go


create procedure AddStudent
@usern varchar(30),
@pass varchar(30),
@name varchar(30),
@gender varchar(6),
@age int,
@dept varchar(30),
@roll char(7), 
@camp varchar(30)

as

begin
	insert into [User]
	values
	(@usern,@pass,@name, @gender, @age)
	
	insert into Borrower
	values
	(@usern, @dept, @camp, @roll)
end
go

create procedure UpdateUser
@usern varchar(30),
@pass varchar(30),
@name varchar(30),
@gender varchar(6),
@age int,
@dept varchar(30),
@roll char(7), 
@camp varchar(30)
as
begin
	if exists (select * from [User] where username = @usern and [password] = @pass)
	begin
		update [User]
		set name = @name, Gender = @gender, Age = @age
		where username = @usern

		update Borrower
		set dept = @dept, campus = @camp, rollno = @roll
		where username = @usern
	end 
	else if exists (select * from [User] where username = @usern)
	begin
		Print 'Incorrect Password'
	end
	--Nothing happens in case user didnt matched
end
go

create procedure SearchByAuthor
@nam varchar(30)
as
begin
	select * from Book where  [Author] = @nam   
end
go

create procedure SearchByISBN
@nam varchar(30)
as
begin
	select * from Book where  [ISBN] = @nam   
end
go

