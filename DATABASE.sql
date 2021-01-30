CREATE TABLE saglik_calisani(
    tc_no char(11) not null, Primary Key (tc_no),
    ad varchar(30) not null,
    soyad varchar(30) not null,
    cinsiyet varchar(10),
    brans varchar(40) not null,
    maas numeric(10) not null
    );

CREATE TABLE hasta(
    had varchar(20) not null,
    hsoyad varchar(20) not null,
    htc_no char(11) not null, Primary Key(htc_no),
    htel_no char(10) not null,
    hsgk_no varchar(12) not null,
    hasta_no numeric(12) not null,
    hdogum_tarihi Date not null,
    hcinsiyet varchar(5) not null,
    hboy varchar(3) not null,
    hkilo varchar(3) not null,
    hadres char(500) not null
);

CREATE TABLE hasta_yakini(
    tc_no char(11) not null,
    hasta_tc_no char(11) not null, Primary Key(hasta_tc_no),
    ad varchar(30) not null,
    soyad varchar(30) not null,
    tel_no numeric(10) not null,
    yakinlik_derecesi varchar(15) not null,
    CONSTRAINT fk_hasta_tc_no
    FOREIGN KEY (hasta_tc_no)
    REFERENCES hasta (htc_no)
    ON DELETE CASCADE
);

CREATE TABLE hizmet(
    saglikci_tc_no char(11) not null,
    hizmet_ad char(20) not null,
    Primary Key (saglikci_tc_no,hizmet_ad),
    ilaclar char(20));
    
   	ALTER TABLE hizmet
    ADD CONSTRAINT fk_hizmet
    FOREIGN KEY (saglikci_tc_no)
    REFERENCES saglik_calisani(tc_no) ON DELETE CASCADE;

CREATE TABLE hastahizmet(
	tcno_hasta varchar(11) not null,
	saglikci_tc_no char(11),
	hizmetAd char(20),
	foreign key (tcno_hasta) references hasta(htc_no) ON DELETE CASCADE,
	foreign key (hizmetAd,saglikci_tc_no) references hizmet(hizmet_ad,saglikci_tc_no) ON DELETE SET NULL
);


CREATE SEQUENCE hastaNoSeq
minvalue 100000000000
increment by 1;


CREATE VIEW hastayakini
as
select had, hsoyad, htc_no, y.ad,y.soyad,y.tc_no,y.tel_no,y.yakinlik_derecesi 
from hasta_yakini y, hasta 
where htc_no = y.hasta_tc_no;



CREATE OR REPLACE FUNCTION saglikci_maasi()
RETURNS trigger as $$
begin
if(new.maas>30000) then
raise notice 'Saglık calisani maasi 30000 tl den yüksek olamaz!';
new.maas=30000;
return new;
else
return new;
end if;
end;
$$ language plpgsql;

CREATE VIEW verilenHizmet
as
select hizmetAd, had ,hsoyad from hizmet, hastahizmet, hasta where
hastahizmet.saglikci_tc_no = hizmet.saglikci_tc_no and hizmet.hizmet_ad=hastahizmet.hizmetAd and tcno_hasta=htc_no;	 


create or replace function hasta_bul(adi varchar(20),tc varchar(11))
returns verilenHizmet as $$
declare
vh verilenHizmet;
begin
select verilenHizmet.* INTO vh from verilenHizmet,hizmet where had like '%' || adi ||'%' and  tc = hizmet.saglikci_tc_no and hizmetad = hizmet.hizmet_ad;
return vh;
end;
$$ language plpgsql;



CREATE TRIGGER saglikci_maas
before update
on saglik_calisani
for each row execute procedure saglikci_maasi();




insert into saglik_calisani values('12345678910', 'ahmet', 'uran', 'erkek', 'nöroloji', 15000); 
insert into saglik_calisani values('23456789120', 'fatma', 'demir', 'kadın', 'diyetisyenlik', 13000 ); 
insert into saglik_calisani values('34567891230', 'ebru', 'güneş', 'kadın', 'psikiyatri', 17000); 
insert into saglik_calisani values('45678912340', 'ahmet', 'tak', 'erkek', 'kardiyoloji', 12500); 
insert into saglik_calisani values('56789123450', 'fuat', 'tuna', 'erkek', 'göz', 12000); 
insert into saglik_calisani values('67891234560', 'murat', 'çelik', 'erkek', 'kulak-burun-boğaz', 12500); 
insert into saglik_calisani values('78912345670', 'deniz', 'yalçın', 'kadın', 'cildiye', 15000); 
insert into saglik_calisani values('89123456780', 'ilkay', 'durmaz', 'kadın', 'ortopedi',20000); 
insert into saglik_calisani values('91234567890', 'tuba', 'demir', 'kadın', 'ortopedi', 23000); 
insert into saglik_calisani values('12345678920', 'derya', 'kaya', 'erkek', 'diyetisyenlik', 12000);

INSERT into hasta values('Ali', 'Kaş', '12345678912', 5320764532, 234564350123, 145678901234, '02-DEC-1970', 'erkek', 180, 80, 'Barbaros mah. Gonca sok. 3/53 Üsküdar/İstanbul');
INSERT into hasta values('Veli', 'Taş', '12343567891', 5323764532, 234567958123, 245678901234, '24-DEC-1960', 'erkek', 181, 70, 'Esenler mah. Menekşe sok. 3/2 Kadıköy/İstanbul');
INSERT into hasta values('Aslı', 'Kara', '32345678912', 5328264532, 234567096123, 345678901234, '14-DEC-1950', 'kadın', 169, 65, 'Çiftehavuzlar mah. Kuşkonmaz sok. 3/73 Kartal/İstanbul');
INSERT into hasta values('Ragıp', 'Gümüş','12345678921', 5321764532, 234593590123, 445678901234, '15-DEC-1945', 'erkek', 163, 90, 'Çiçekçi mah. Karanfil sok. 3/23 Zeytinburnu/İstanbul');
INSERT into hasta values('Cenk', 'Pala', '12345674212', 5328434532, 234567863123, 545678901234, '25-Apr-1930', 'erkek', 184, 85, 'Burhaniye mah. Leylak sok. 3/63 Ümraniye/İstanbul');
INSERT into hasta values('Seyfi', 'Demir', '32145678912', 5328654532, 234567901253, 645678901234, '10-Oct-1935', 'erkek', 185, 70, 'Yıldırım mah. Kat sok. 3/27 Kadıköy/İstanbul');
INSERT into hasta values('Mahir', 'İz', '86545678912', 5328764542, 234567861123, 745678901234, '20-Jan-1955', 'erkek', 186, 75, 'Balkan mah. Tan sok. 3/22 Sarıyer/İstanbul');
INSERT into hasta values('Leman', 'Kurt', '12344568912', 5328634532, 234567890993, 845678901234, '12-Dec-1965', 'kadın', 157, 83, 'Altunizade mah. Fener sok. 32/23 Beşiktaş/İstanbul');
INSERT into hasta values('Zeki', 'Fener', '12345678732', 5328764952, 234567808123, 945678901234, '12-JuL-1948', 'erkek', 188, 86, 'Acıbadem mah. Bülbül sok. 33/23 /İstanbul');
INSERT into hasta values('Barbaros','Hayrettin','12345670912', 5325964532, 234577890123, 305678901234, '11-DEC-1959', 'erkek', 189, 88, 'İstinye mah. Keten sok. 3/83 Üsküdar/İstanbul');


insert into hasta_yakini values('72345678952','12345678912', 'Gamze', 'Kaş', 5351232236, 'kızı');
insert into hasta_yakini values('48345678912','12343567891', 'Hatice', 'Taş', 5361212636, 'eşi');
insert into hasta_yakini values('67345678912','32345678912', 'Ömer', 'Kara', 5064258791, 'eşi');
insert into hasta_yakini values('25345678912','12345678921', 'Miray', 'Gümüş', 5352132615, 'eşi');
insert into hasta_yakini values('47345678912','12345674212', 'Murat', 'Pala', 5354827516, 'oğlu');
insert into hasta_yakini values('56345678912','32145678912', 'Ayşe', 'Demir', 5392216632, 'kızı');
insert into hasta_yakini values('89345678912','86545678912', 'Sevgi', 'İz', 5325562648, 'kızı');
insert into hasta_yakini values('12342178912','12344568912', 'Furkan', 'Kurt', 5359945126, 'oğlu');
insert into hasta_yakini values('12349678912','12345678732', 'Ali', 'Fener', 5354412562, 'oğlu');
insert into hasta_yakini values('12365678912','12345670912', 'Ecrin', 'Hayrettin', 5353311226, 'kızı');

insert into hizmet values('12345678910','Zatüre','Augmentin');
insert into hizmet values('23456789120','Kan alma','Coraspin');
insert into hizmet values('34567891230','Diyaliz',null);
insert into hizmet values('45678912340','Fizik Tedavi',null);
insert into hizmet values('56789123450','Psikiyatr','Antidepresan');
insert into hizmet values( '67891234560','Psikiyatr','Cypralex');
insert into hizmet values('78912345670','Dahiliye','Gynoferon');
insert into hizmet values('89123456780','Ortopedi','Osteocare');
insert into hizmet values('91234567890','Serum', null);
insert into hizmet values('12345678920','Pansuman',null);


insert into hastahizmet values('12345678912','12345678910','Zatüre');
insert into hastahizmet values('12343567891', '23456789120', 'Kan alma');
insert into hastahizmet values('32345678912', '34567891230', 'Diyaliz');
insert into hastahizmet values('12345678921', '45678912340', 'Fizik Tedavi');
insert into hastahizmet values('12345674212', '56789123450', 'Psikiyatr');
insert into hastahizmet values('32145678912', '67891234560', 'Psikiyatr');
insert into hastahizmet values('86545678912', '78912345670', 'Dahiliye');
insert into hastahizmet values('12344568912', '89123456780', 'Ortopedi');
insert into hastahizmet values('12345678732','91234567890', 'Serum');
insert into hastahizmet values('12345670912', '12345678920', 'Pansuman');


create function haftasonu_hasta()
returns trigger as $$
begin
if(to_char(now(),'DY')in('SAT','SUN')or to_char(now(),'HH24')not between '08' and '18') then
raise 'Sadece mesai günlerinde ve mesai saatlerinde insert yapabilirsiniz.';
return null;
else
return new;
end if;
end;
$$ language plpgsql;
create trigger haftasonu_hastaa
before insert
on hasta
for each row execute procedure haftasonu_hasta();

CREATE Or Replace VIEW hastalarım
as
select ha.*,hi.saglikci_tc_no from hasta ha,hizmet hi,hastahizmet hh where hh.tcno_hasta = ha.htc_no
and hh.hizmetAd = hi.hizmet_ad and hh.saglikci_tc_no = hi.saglikci_tc_no;

create type saglikcii as(tc_no varchar(11),ad varchar(30), soyad varchar(30));

create or replace function saglıkci_bulmaa(tcno char(11))
returns saglikcii[] as $$
declare 
emp_cursor cursor for select tc_no, ad, soyad from saglik_calisani 
where tc_no like '%'||tcno||'%';
sag saglikcii[];
i integer;
begin 
i:=1;
for emp_record in emp_cursor loop
sag[i]=emp_record;
i:=i+1;
end loop;
return sag;
end;
$$ language plpgsql;


create type Bulunan_Hasta as (hizmetAd varchar(20),Had varchar(20),Hsoyad varchar(20));




create or replace function hast_bul(adi varchar(20),tc varchar(11))
returns Bulunan_Hasta[] as $$
declare

emp_cursor CURSOR FOR SELECT  verilenHizmet.*  from verilenHizmet,hizmet
where had like '%'|| adi || '%' and  tc = hizmet.saglikci_tc_no and hizmet_ad =  hizmetAd;
hasta  Bulunan_Hasta[];
i integer;
begin
i=1;

FOR emp_record IN emp_cursor LOOP
hasta[i]=emp_record;
i=i+1;
END LOOP;

return hasta;
end;
$$ language plpgsql;

create type hizmetlerim as(saglikci_tc_no char(11), hizmet_ad char(20), ilaclar char(20));

create or replace function hizmet_bulma(htcno char(11))
returns hizmetlerim[] as $$
declare 
emp_cursor cursor for select saglikci_tc_no, hizmet_ad, ilaclar from hizmet, hasta 
where htc_no=htcno;
hiz hizmetlerim[];
i integer;
begin
i:=1;
for emp_record in emp_cursor loop
hiz[i]=emp_record;
i:=i+1;
end loop;
return hiz;
end;
$$ language plpgsql;