# Android Ders Notları
2020 Mobil programlama dersine ait, açıklamalar ile birlikte tüm uygulamalar, ödevler ve notlar

# Hafta 1 
<br>
<h2>Android Nedir</h2>

- Andorid, linux çekirdeği üzerine geliştirilmiş açık kaynak kodlu işletim sistemidir.

- Mobil (taşınabilir) cihazlar hedeflenmiştir.

- Google ve Open Handset Alliance birliği tarafından geliştirilmektedir. <br><br><br>


<h2>Android'in Mimari Yapısı</h2>

[![2000px-Android-System-Architecture-svg.png](https://i.postimg.cc/prm9jMN1/2000px-Android-System-Architecture-svg.png)](https://postimg.cc/8fVP83zh)

<h4>Applications :</h4> Kullanıcı ile etkileşim sağlanan katmandır. Bildiğimiz, kullandığımız uygulamalar bu katmanda yer alır. Örneğin instagram,whatsapp,browser...

<h4>Application Framework :</h4> Bir üst katmandaki uygulamalarımızın çalışması için gerekli kütüphaneler topluluğudur. Uygulamalarımızı geliştirmek için bu kütüphanleri kullanırız.

<h4>Libraries :</h4> C ile yazılmış sistem kütüphanleridir. Örneğin SQLite local bir veritabanı oluşturma imkanı tanır. Opengl/es grafik işlemleri için gerekli kütüphanedir.

<h4>Android Runtime :</h4> Java ile yazılmış çekirdek kütüphaneler ve işletim sistemini donanımdan ayıran sanal makine bulunur.

<h4>Linux Kernel :</h4> Android mimarisinin en alt katmanıdır. Donanım sürücüleri burada bulunur. Örneğin kamera sürücüsü , güç yönetimi... <br><br><br>



<h2>Android'in Gelişimi</h2>

- <strong>Android 1.0 (Apple Pie HTC Dream) : </strong>  Kamera desteği , wi-fi,bluetooth,browser,alarmlı saat ,youtube ...

- <strong>Android 1.1 (Banana Bread ) : </strong> Sistem hataları düzeltildi, api geliştirildi.

- <strong>Android 1.5 (Cupcake) : </strong> Kamera kaydı, video gösterimi, Picasa,Widget'ları kişiselleştirebilme, animasyonlu ekran özellikleri... 

- <strong>Android 1.6 (Donut) : </strong> Ekran çözünürlüğünün yükseltilmesi , geliştrililmiş android market ,galeride çoklu silme...

- <strong>Android 2.0-2.1 (Eclair) : </strong> html5,bluetooth 2.1 , sanal klavye ,  geliştirilmiş google maps , arayüz özelleştirme...

- <strong>Android 2.2 (Froyo) : </strong> 720p ekran çözünürlüğü, usb bağlantı, wi-fi tarama , flash player 10.1 ...

- <strong>Android 2.3 (Ginger bread) : </strong> Çoklu kamera ve çoklu dokunmatik desteği , video arama ...

- <strong>Android 3.0 (Honey comb) : </strong> sadece tabletlere özel sürümümü (şuan hem telefonlara hem tabletlere uyumlu tek sürüm yayınlanıyor)

- <strong>Android 4.0 (Ice cream sandwich) : </strong> Yüz tanıma fonksiyonları, NFC ile dosya paylaşımı...

- <strong>Android 4.1 (Jelly bean) : </strong> Aynı anda iki uygulama açma , takılmadan kayan ekran, enerji verimliliği , performans...

- <strong>Android 4.4 (Kitkat) : </strong> Görsel arayüzde bir çok değişiklik, ram optimizasyonu , Dalvik alternatifi ART sanal makinası...

- <strong>Android 5.0 (Lollipop) : </strong>

- <strong>Android 6.0 (Marshmallow) : </strong>

- <strong>Android 7.0 (Naugat) : </strong>

- <strong>Android 8.0 (Oreo) : </strong>

- <strong>Android 9.0 (Pie) : </strong>

- <strong>Android 10.0 (10) : </strong> 3 eylül 2019

- <strong>Android 11.0 (11) : </strong> 8 eylül 2020

**Not :** Her android versiyonu bir api numarası ile gelir.

**Not :** Uygulama oluşturulurken minumum api belirlenir (sonradan değiştirilebilir). Uygulamamızı bu api numarasının altında android versiyonu yüklü telefonlar kullanamaz.

**Not :** Belirlediğimiz minumum api'den sonra gelen özellikleri kullanamayız. (Kullanabiliriz ama bir çok test yapmamız gerekir önceki verisyonlarda çalışıyor mu diye)
<br><br><br>


<h2>Bilinmesi Gerekenler</h2>

<h4>Xml</h4>

- Android'te tasarım ve veri kaynağı olarak xml(extensible markup language) kullanılır.
- Xml veri taşıma standardıdır.(farklı sistemler arasında ortak dil olarak kullanılır)
- Aynı zamanda bir işaretleme,görüntüleme dilidir. (Android'te bu amaçla kullanılır)
- Xml ile kendi etiketlerimizi (tag) oluşturabiliriz. (Android için kullanılan etiketler bu sayede tanımlanmıştır)
- Her xml dosyasında sadece bir kök(root) eleman bulunabilir. Bu kök içerisinde aynı düzeyde elemanlar tanımlanabilir.

<h4>Java</h4>

- Andorid'te tasarımlara işlev kazandırmak içim java pogramlama dili kullanılır. Alternatif : kotlin

**xml ile java kodları arasındaki bağlantı R.java konfigürasyon dosyası üzerinden sağlanır.**


**Not :** Java ile android uygulamalar geliştirebilmek için jdk(java development kit) ve android sdk(software developtment kit) sistemde kurulu olmalıdır.

**Not :** Bu dersin kapsamı dışında olan bir çok android uygulama geliştirme alternatifi bulunmaktadır.

<hr><hr>


<h1>Hafta 2</h1>

- Kullanıcının gördüğü arayüzlere Activity denir. Bir class ın Activity olabilmesi için AppCompatActivity classını extend etmesi gerekir.
- Her activity onCreate method undan çalışmaya başlar.
- setContentView() methodu ile Activity nin hangi xml dosyası ile çalışacağı set edilir.
- Android uygulamalarının 3 ana parçası bulunur. AndroidManifest.xml  dosyası , java  ve res  klasörleridir.
- AndroidManifest.xml : uygulamanın genel konfigürasyon dosyasıdır. İzinler,uygulama ikonu , Activityler, Intendler,tema vs ... burada tanımlıdır.
- java klasörü : tüm java kodları burada bulunur.
- res klasörü  : görüntü,ses,uygulamanın kullandığı metinler,arayüz tasarımları , renk bilgileri... kısaca uyugulamanın kullandığı tüm kaynaklar buradadır.
- res klasörü altında bulunan mipmap klasöründe aynı görüntünün faklı çözünürlükte 6 kopyası bulunur. Uygulamanın açıldığı ekranın çözünürlüğüne göre uygun olan otomatik olarak    seçilir.
- res klasörü altında bulunan values klasöründe uygulamanın metinsel verileri tutulur.
- res klasörü altında bulunan layout klasöründe arayüz tasarımları bulunur.
- java kodunda R sınıfı ile res klasörü arasında bağlantı kurulur.
- Gradle uygulama geliştirme sürecini otomotize eden bir araçtır. Örneğin uygulamamızda kullanacağımız bir kütüphaneyi gradle a belirtir. Gradle otomotik olarak indirip uygulamaya dahil eder.
- Ekranda görünen her nesne bir view nesnesidir. Bir view elamanına tıkladığımızda eğer varsa onClick methodu tetiklenir.
- Intendler activiteler arası geçiş yapan ayrıca veri taşıyabilen nesnedir.


<hr><hr>
<h1>Hafta 3</h1>

- View nesnelerine (TextView,EditText,Button...)  setOnClickListener() methodu ile dinleyici bir sınıf set edebiliriz.
- setOnClickListener() methodu parametre olarak View.OnClickListener interface'sini implemente eden bir sınıf alır.
- View nesnesine tıklandığında bu sınıfa ait olan onClick methodu tıklanan view nesnesini parametre alarak çağrılır.
- Kısaca view nesnesine tıklandığında dinleyici sınıfın onClick methodu çağrılır.

Bu örnekte dinleyici sınıf anonim olarak tanımlanmış

```
buttonComputeMass.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        
    }
});
```

- Hocanın CalculatorActivity'de uyguladığı yöntem bundan faklı bir şey değil.Nesnelere dinleyici sınıf set etmek için setOnClickListener() methoduna this parametresi  gönderiyor. This CalculatorActivity'i referans ediyor.CalculatorActivity'de View.OnClickListener interfacesini implemente eden bir sınıf olduğundan değişen bir şey olmuyor.


<hr><hr>
<h1>Hafta 4</h1>

- Android cihaz üreten bir çok üretici firma olduğundan piyasada çok faklı çözünürlükte android cihazlar bulunmaktadır.
Bu nedenle uygulama tasarımlarının responsive yani cihaz çözürlüğüne göre boyutlanması gerekir. Bu amaçla linearLayout,
RelativLayout,FrameLayout,Constraintlayout... gibi bir çok layout çeşidi oluşturulmuştur. Tasarım amacına uygun olarak 
istenen layout çeşidi ile tasarım yapılabilir.

<h4>LinearLayout</h4>
    
- Elemanlar yatay veya dikey olarak konumlanırlar.
- Eğer orientation niteliğine vertical değeri verilirse dikey , horizontal değeri verilirse yatay olarak sıralanırlar.
- Her satıra veya her stuna sadece bir eleman yerleşebilir.
- Diğer bir önemli özelliği ise layout_weight'dir. Bu özellik ile elemanların kaplayacağı alan ağırlık  olarak verilir.
Örneğin yatay sıralanan bir linearLayout'ta 2 eleman olsun. 1.elmanın layout_weight değeri 1  olsun. 2.elemanın laout_weight
değeri 2 olsun. Bu durumda ekran yatayda üçe eşit parçaya bölünür. Birince elemana 1 parça 2.elemana ise 2 parça verilir.
Not : elemanların genişlik değeri 0dp olmalıdır. 
Not : Benzer mantık dikey linearLayout için de geçerlidir.


<h4>ConstraintLayout</h4>

- Her eleman kendisine verilen constraint(sınır) değerlerine göre konumlandırılır.


<h4>RelativeLayout</h4>

- Her eleman diğer bir elemana veya ekranın kenar ve köşelerine göre göreceli olarak konumlandırılır.

- <strong>layout_above :  </strong> Hangi görsel öğenin id’si verilmişse onun üstünde görünür
- <strong>layout_below :  </strong> Hangi görsel öğenin id’si verilmişse onun altında görünür
- <strong>layout_toLeftOf :  </strong> Hangi görsel öğenin id’si verilmişse onun solunda görünür
- <strong>layout_toRightOf :  </strong> Hangi görsel öğenin id’si verilmişse onun sağında görünür <br><br>

- <strong>android:layout_alignParentBottom:</strong> İçine koyulduğu layout’un en altına yerleşmesine yarar. (true-false)
- <strong>layout_alignParentLeft:</strong> İçine koyulduğu layout’un en soluna yerleşmesine yarar. (true-false) 
- <strong>android:layout_alignParentRight:</strong> İçine koyulduğu layout’un en sağına yerleşmesine yarar. (true-false)
- <strong>android:layout_alignParentTop :</strong> İçine koyulduğu layout’un en üstüne yerleşmesine yarar. (true-false)
- ...






<h4>FrameLayout</h4>

- Ekran 9 parçaya bölünür. Elemanların hangi parçaya yerleşeceği layout_gravity özelliği ile belirtilir.
  örneğin : layout_gravity = "bottom|right"  özelliği elemanı 9.parçaya yerleştirir.
  
  
<h4>GridLayout</h4>
 
 - Ekran matris yapısı gibi hücrelere bölünür. Elemanlar kendilerine verilen satır ve stun numarasına göre konumlandırılır.
 örneğin : layout_column="0" layout_row="0" ile eleman 1. hücreye yerleştirilir.
 
 
<h4>TableLayout</h4>
 
 - Html'deki table yapısına benzerdir. Tabloya satır eklemek için ```<TableRow>``` etiketi , satırsaki elemanın ağırlığını belirlemek için ise layout_span özelliği kullanılır.
 


<hr><hr>
<h1>Hafta 5</h1>

<h4>Intend </h4>

- Activity'ler arası geçiş
- Activity'ler arası veri transferi
- Broadcast Receiver çağırma
- Service çağırma
- Sistemde bulunan diğer uygulamaları çağırma (sms,browser,mail,sosyal medya...) 
- ... gibi amaçlar ile kullanılır.

<strong>Not : </strong> Her uygulama faklı özelliklere sahip olduğundan intend tipimiz ve  intend'e set etiğimiz veriler , intendimizi
karşılamasını istediğimiz uygulamaya uygun olmalıdır.

<strong> Intend ile başka bir activity'den veri alıp geri dönebiliriz</strong>

- startActivityForResult() ile veri almak istediğimiz Activity'e geçiş yapılır.
- Bu method gerekli intend ve request_code paramtrelerini alır.
- request_code herhangi bir int sayıdır ve doğrulama amacıyla kullanılır. <br><br>
- setResult() ile veri aldığımız activity'den geri döneriz.
- Bu method gerekli datayı set ettiğimiz intend ve sabit int bir değer (ör :RESULT_OK) paramtrelerini alır. <br><br>
- Gelen datayı karşılamak için onActivityResult() override edilir.
- requestCode ve ResultCode parametreleri ile gelen datanın istekte bulunduğumuz data olup olmadığı kontrol edilir.
- kontrol geçilirse data parametresi istekte bulunduğumuz datadır.



<hr><hr>
<h1>Hafta 6</h1>

<h4>Permissions</h4>

Api 23 (Marshmallow) öncesi tüm izinler uygulama indirilirken verilirdi. Api 23 ve sonrası için başlangıç izinleri yerine
anlık izinlere geçildi.

<h5>İzin Algoritması</h5>

Örneğin uygulama kameraya erişmek istesin.

- 1- Öncelikle izin kontrolu yapılır. (Kullanıcı bu uygulama için daha önceden kamera erişim izni vermiş mi ?)
- 2- Platform kontrolü yapılır. (Api 23 öncesi mi sonrası mı ? - buna şuan(2020) gerek yok- yerine ActivityCompat geldi)
- 3- Gerekli izin ile ilgili açıklama yapılır (isteğe bağlı)
- 4- izin isteğide bulunulur
- 5- izin isteğine verilen yanıt kontrol edilir. (izin verilmişse kameraya erişilir.) <br><br>

- 1- checkSelfPermission()
- 2- if(Build.VERSION.SDK_INT >=23)  
- 3- shouldShowRequestPermissionRationale() --> Kullanıcının kafası karışıksa true döner - açıklama yaparız. <br>
<stong>Kafası karışık olma durumu :</strong><br>
Uygulama ilk kez çalıştırılıyorsa false döner . (kullanıcının kafası karışık değil) <br>
Uygulama 2.kez veya daha fazla çalıştırılmışsa <br>
--> Eğer izne daha önceden olumsuz yanıt verilmiş ise ve bir daha sorma **işaretlenmişse** false döner . (Kafa karışık değil) <br>
--> Eğer izne daha önceden olumsuz yanıt verilmiş ise ve bir daha sorma **işaretlenmemişse** true döner (Kafa karışık -açıklama yaparız) <br>
- 4- requestPermissions() --> gerekli izinler dizi olarak verilir. Ayrıca doğrulama amaçlı reuest_code verilir.
- 5-onRequestPermissionResult()-->  verilen tüm izinleri bu method karşılar. Bu nedenle override edilmesi gerekir. Request code ile kullanıcının verdiği iznin istediğimiz izin olup olmadığı kontrol edilir.

Not : Anlık izinler sadece dangerous permission için gereklidir.  Ör : kamera,konum,galeri…



<hr><hr>
<h1>Hafta 7</h1>
<h4>SQLite</h4>

- SQLite local veritabanı oluşturmak için kullanılan kütüphanedir. Android mimrasine gömülü olarak geldiğinden ekstra olarak uygulamaya eklemeye gerek yoktur.

- Local veritabanı : dışarıya açık olmayan , verilerin cihaz hafızasında tutulduğu  , uygulamaya özel olan veritabandır.

- Bir SQLite veri tabanı oluşturmak için **SQLiteOpenHelper** soyut sınıfını miras alıp ihtiyacımıza uygun olarak özelleştiririz.

- Veritabanının adı bu sınıfın Constructor'ına verilir.

- onCreate() methodu sadece uygulama yüklenirken bir kere çalıştırılan methoddur. Bu nedenle ihtiacımız olan tabloları bu method içerisinde oluştururuz.

- Tablo oluşturma, tabloya eleman ekleme ,silme,güncelleme... işlemleri için **SQLiteDatabase** nesnesi kullanılır.

- **ContentValues** nesnesi, veritabanına eleman ekleme,güncelleme için gerekli veri formatıdır.

- **Cursor nesnesi**, sorguya göre veritabanından çekilen kayıtları tutmak için kullanılır.













 
  


    















































