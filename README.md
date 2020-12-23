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
















































