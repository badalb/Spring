insert into tblrole values ('r1111', 'Solution Specialist', 'Solution Specialist', 'N', now(), 'system', now(), 'system', 'N');
insert into tblrole values ('r1112', 'ILM', 'ILM', 'N', now(), 'system', now(), 'system', 'N');
insert into tblrole values ('r1113', 'Asset Manager', 'Asset Manager', 'N', now(), 'system', now(), 'system', 'N');
insert into tblrole values ('r1114', 'Manager', 'Property Manager', 'N', now(), 'system', now(), 'system', 'N');
insert into tblrole values ('r1115', 'Administrator', 'Administrator', 'N', now(), 'system', now(), 'system', 'N');

insert into tblpermission values ('p11111', ' VendorManagement', 'VendorManagement', 'Vendor Management','N', now(), 'system','system', now(), 'N' );
insert into tblpermission values ('p11112', ' VendorSearch', 'VendorSearch', 'Vendor Management','N', now(), 'system','system', now(), 'N' );


insert into tblrole_permission values ('rp0001','p11111','r1115', now(), 'N', 'system', 'system', now(), 'N');
insert into tblrole_permission values ('rp0002','p11112','r1115', now(), 'N', 'system', 'system', now(), 'N');

insert into tblrole_permission values ('rp0003','p11111','r1113', now(), 'N', 'system', 'system', now(), 'N');
insert into tblrole_permission values ('rp0004','p11112','r1113', now(), 'N', 'system', 'system', now(), 'N');

insert  into `tbluser`(`user_id`,`user_name`,`first_name`,`last_name`,`is_inactive`,`is_locked`,`password`,`created_date`,`last_login_date`,`last_modified_date`,`created_by`,`last_modified_by`,`is_deleted`) 
values ('sysusr1','admin','John','Terry','N','N','password','2014-10-10 10:10:05',NULL,NULL,NULL,NULL,'N');

insert  into `tbluser`(`user_id`,`user_name`,`first_name`,`last_name`,`is_inactive`,`is_locked`,`password`,`created_date`,`last_login_date`,`last_modified_date`,`created_by`,`last_modified_by`,`is_deleted`) 
values ('sysusr2','user','Joe','Hart','N','N','password','2014-10-10 10:10:05',NULL,NULL,NULL,NULL,'N');


insert  into `tbluser_role`(`user_role_id`,`user_id`,`role_id`,`is_default`,`created_date`,`created_by`,`last_modified_date`,`last_modified_by`,`is_deleted`) 
values ('usrr1','sysusr1','r1115','N','2014-10-10 10:10:10','system','2014-10-10 10:10:10','system','N');

insert  into `tbluser_role`(`user_role_id`,`user_id`,`role_id`,`is_default`,`created_date`,`created_by`,`last_modified_date`,`last_modified_by`,`is_deleted`) 
values ('usrr2','sysusr2','r1113','N','2014-10-10 10:10:10','system','2014-10-10 10:10:10','system','N');