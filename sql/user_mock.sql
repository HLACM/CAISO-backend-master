INSERT INTO user (userAccount, userPassword, unionId, mpOpenId, userName, userAvatar, userProfile, userRole, createTime, updateTime, isDelete)
VALUES
    ('test1@example.com', '05c3976aa9138a1f78cf442379fe5126', 'unionid123', 'openid123', 'John Doe', 'avatar.jpg', 'I am a user', 'user', NOW(), NOW(), 0),
    ('test2@example.com', '05c3976aa9138a1f78cf442379fe5126', NULL, NULL, 'Jane Smith', 'avatar.jpg', NULL, 'user', NOW(), NOW(), 0),
    ('test3@example.com', '05c3976aa9138a1f78cf442379fe5126', NULL, NULL, 'Mike Johnson', 'avatar.jpg', 'I love coding', 'user', NOW(), NOW(), 0),
    ('test4@example.com', '05c3976aa9138a1f78cf442379fe5126', NULL, NULL, 'Emily Brown', 'avatar.jpg', NULL, 'user', NOW(), NOW(), 0),
    ('test5@example.com', '05c3976aa9138a1f78cf442379fe5126', NULL, NULL, 'Daniel Wilson', 'avatar.jpg', 'Software Engineer', 'user', NOW(), NOW(), 0);
