--Sample data for table ADDRESSES
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'한화리조트','속초','강원','92110','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'메리어트','성남','경기','32347','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'힐튼','부산','경남','52417','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'워커힐','대전','충남','65410','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'롯데','제주','제주','56432','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'이비스','대구','경남','52417','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'신라','대전','충남','65410','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'프레지던트','제주','제주','56432','대한민국');
INSERT INTO ADDRESS (ADDR_ID,STREET,CITY,STATE,ZIP,COUNTRY) VALUES (ADDRESS_ADDR_ID_SEQ.nextval,'신라호텔','속초','속초','37889','대한민국');

-- Sample data for table STUDENTS
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'이윤호','jhy@gmail.com','123-123-1234','2000-04-25',4);
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'정수환','pcm@gmail.com','789-456-1234','1999-07-12',5);
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'김미영','khm@gmail.com','321-547-2135','2001-03-07',6);
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'권순수','khm@gmail.com','321-865-3478','2001-08-08',7);
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'천주영','sse@gmail.com','543-342-6712','2001-02-15',8);
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'이현우','lee@gmail.com','321-434-6666','2004-06-30',9);
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'김현우','khm@gmail.com','321-865-6543','2001-06-30',9);
INSERT INTO STUDENT (STUD_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES (STUDENT_STUD_ID_SEQ.nextval,'신혜원','jsh@gmail.com','788-667-9090','2001-12-30',NULL);

-- Sample data for table TUTORS

INSERT INTO TUTOR (TUTOR_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES(TUTOR_TUTOR_ID_SEQ.NEXTVAL,'김경호','kim@gmail.com','019-365-8963','1980-05-20',1);
INSERT INTO TUTOR (TUTOR_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES(TUTOR_TUTOR_ID_SEQ.NEXTVAL,'장동건','jang@gmail.com','011-753-4521','1981-03-15',2);
INSERT INTO TUTOR (TUTOR_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES(TUTOR_TUTOR_ID_SEQ.NEXTVAL,'이소라','sora2@gmail.com','010-247-7843','1990-04-12',3);
INSERT INTO TUTOR (TUTOR_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES(TUTOR_TUTOR_ID_SEQ.NEXTVAL,'삼소라','sora3@gmail.com','010-247-7843','1990-04-12',3);
INSERT INTO TUTOR (TUTOR_ID,NAME,EMAIL,PHONE,DOB,ADDR_ID) VALUES(TUTOR_TUTOR_ID_SEQ.NEXTVAL,'이효리','sogil@gmail.com','018-321-3589','1990-08-15',NULL);

-- Sample data for table courses

INSERT INTO COURSE (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES (COURSE_COURSE_ID_SEQ.NEXTVAL,'Quickstart Core Java','Core Java Programming','2019-01-01','2019-02-20',1);
INSERT INTO COURSE (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES (COURSE_COURSE_ID_SEQ.NEXTVAL,'Quickstart Spring','Enterprise App Development using Spring','2019-03-01','2019-05-30',1);
INSERT INTO COURSE (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES (COURSE_COURSE_ID_SEQ.NEXTVAL,'MyBatis Premier','MyBatis  framework','2020-03-01','2020-06-14',1);
INSERT INTO COURSE (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES (COURSE_COURSE_ID_SEQ.NEXTVAL,'Database Modeling','Oracle Database Modeling','2020-06-15','2020-07-14',2);
INSERT INTO COURSE (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES (COURSE_COURSE_ID_SEQ.NEXTVAL,'Java Tutorial ','Java Tutorial for Complete Beginners','2020-04-01','2020-05-15',2);
INSERT INTO COURSE (COURSE_ID,NAME,DESCRIPTION,START_DATE,END_DATE,TUTOR_ID) VALUES (COURSE_COURSE_ID_SEQ.NEXTVAL,'Core JavaScript ','Core JavaScript Guide','2020-03-04','2020-07-3',3);

-- Sample data for table COURSE_ENROLLMENT

INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,1,1);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,1,2);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,1,3);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,2,1);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,2,2);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,3,4);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,3,5);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,3,6);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,4,1);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,4,2);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,4,7);
INSERT INTO COURSE_ENROLLMENT (COURSE_ENROLLMENT_ID,COURSE_ID,STUD_ID) VALUES(COURSE_ENROLLMENT_ID_SEQ.NEXTVAL,5,1);




commit;

