# Library API

Spring Boot ile yaptığım kütüphane yönetim REST API projesi.

## Kullanılan Teknolojiler

* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Spring Security
* Swagger
* Maven

## Özellikler

* Kullanıcı ekleme, listeleme ve silme
* Kitap ekleme, listeleme ve silme
* Kitap adına göre arama
* Kitap durumuna göre filtreleme
* Kitap ödünç alma
* Kitap iade etme
* Bir kullanıcının en fazla 3 aktif kitabı olabilmesi
* Ödünç alınmış kitabın tekrar alınmasının engellenmesi
* İade edilmiş kitabın tekrar iade edilmesinin engellenmesi
* 14 günlük ödünç süresi
* Exception handling
* DTO ve Mapper kullanımı
* Spring Security ile kullanıcı rolleri
* Swagger ile API testleri

## Entityler

Projede 3 ana entity var:

* User
* Book
* Loan

İlişki:

```text
User 1 ─── * Loan * ─── 1 Book
```

Loan üzerinden kullanıcının hangi kitabı aldığı takip ediliyor.

## Book Status

Kitabın iki durumu var:

```text
AVAILABLE
BORROWED
```

`AVAILABLE` olan kitap ödünç alınabilir.

`BORROWED` olan kitap başka bir kullanıcı tarafından alınmıştır.

## Loan Status

```text
BORROWED
RETURNED
```

Kitap alındığında `BORROWED`, iade edildiğinde `RETURNED` oluyor.

## Kitap Arama

Kitap adına göre arama yapılabiliyor.
