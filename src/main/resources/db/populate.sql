use `online_courses`;

INSERT INTO  `categories`  ( category_id ,  category_type ) VALUES
	(1, 'category1'),
	(2, 'category2');

INSERT INTO  `roles`  ( role_id ,  role_type ) VALUES
(1, 'role1'),
(2, 'role2');

INSERT INTO  `courses`  ( course_id ,  category_id ,  title ) VALUES
	(1, '1', 'Course1'),
	(52, '2', 'Course2');

INSERT INTO  `users`  ( user_id ,  role_id ,  email ,  password ,  picture_url ,  username ) VALUES
	(90, 2, 'chavdarov.bobysda1@gmail.com', '{bcrypt}$2a$10$j/k4rjKPsM.GP34S4LBc4eXwjuksdww1tUsG0G.Cj2bjjg19kFQBi', 'https://i.ytimg.com/vi/yD_oR8G38Sg/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCvyrdPFcgb-MoXxUDpIGY_6Om6cg', 'user1');
