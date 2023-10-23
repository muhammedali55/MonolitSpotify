# UYGULAMA İÇİ HATA KODLARI

## Yazım Şekli

    X X X X
    | | | |
    | | | ----------- Hata Şekli
    | | ------------- Hata Türü
    | --------------- İşlev No
    ----------------- Katman No

### Hata Türü 1XXX -> Servis Katmanı

    1001 -> User Profile Şifre Uyuşmazlığı Sorunu
    kullanıcı .... end point ine istek gönderir. gönderdiği parametrelerde, şifreler birt birine uyuşmuyor
    ise uygulama bu hatayı fırlatır ve kayıt başarısız olur.
    