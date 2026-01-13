package id.hafiz.tatacarasholat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Views
    private RecyclerView rvGuide, rvDoa;
    private TextView tvHeaderTitle, tvHeaderDesc;
    private BottomNavigationView bottomNav;

    // Adapters & Data
    private GuideAdapter guideAdapter;
    private DoaAdapter doaAdapter;
    private List<PrayerStep> prayerSteps;
    private List<Doa> doaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize Views
        rvGuide = findViewById(R.id.rv_guide);
        rvDoa = findViewById(R.id.rv_doa);
        tvHeaderTitle = findViewById(R.id.tv_header_title);
        tvHeaderDesc = findViewById(R.id.tv_header_desc);
        bottomNav = findViewById(R.id.bottom_navigation);

        // 2. Initialize Data
        initPrayerData();
        initDoaData();

        // 3. Setup RecyclerViews
        setupRecyclerViews();

        // 4. Setup Bottom Navigation Listener
        setupNavigation();
    }

    private void setupRecyclerViews() {
        // Setup Guide List
        rvGuide.setLayoutManager(new LinearLayoutManager(this));
        guideAdapter = new GuideAdapter(this, prayerSteps);
        rvGuide.setAdapter(guideAdapter);

        // Setup Doa List
        rvDoa.setLayoutManager(new LinearLayoutManager(this));
        doaAdapter = new DoaAdapter(this, doaList);
        rvDoa.setAdapter(doaAdapter);
    }

    private void setupNavigation() {
        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_guide) {

                rvGuide.setVisibility(View.VISIBLE);
                rvDoa.setVisibility(View.GONE);


                tvHeaderTitle.setText("Panduan Sholat");
                tvHeaderDesc.setText("Pelajari gerakan dan bacaan sholat fardhu.");

                return true;

            } else if (itemId == R.id.nav_doa) {

                rvGuide.setVisibility(View.GONE);
                rvDoa.setVisibility(View.VISIBLE);


                tvHeaderTitle.setText("Kumpulan Doa");
                tvHeaderDesc.setText("Doa-doa harian dan dzikir setelah sholat.");

                return true;
            }
            return false;
        });
    }

    private void initDoaData() {
        doaList = new ArrayList<>();

        doaList.add(new Doa(1, "Sehari-hari", "Doa Sebelum Tidur",
                "بِسْمِكَ اللّهُمَّ اَحْيَا وَ بِسْمِكَ اَمُوْتُ",
                "Bismika Allahumma ahyaa wa bismika amuut",
                "Dengan nama-Mu Ya Allah aku hidup, dan dengan nama-Mu aku mati."));

        doaList.add(new Doa(2, "Sehari-hari", "Doa Bangun Tidur",
                "الْحَمْدُ لِلَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُورُ",
                "Alhamdulillahil ladzi ahyana ba'da ma amatana wailaihin nusyur",
                "Segala puji bagi Allah yang menghidupkan kami kembali setelah mematikan kami dan kepada-Nya kami akan kembali."));

        doaList.add(new Doa(3, "Sholat", "Doa Qunut Subuh",
                "اللَّهُمَّ اهْدِنِي فِيمَنْ هَدَيْتَ...",
                "Allahummah dinii fiiman hadait...",
                "Ya Allah, berilah aku petunjuk sebagaimana orang-orang yang telah Engkau beri petunjuk..."));

        doaList.add(new Doa(4, "Sholat", "Doa Selamat Dunia Akhirat",
                "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
                "Rabbana aatina fid dunya hasanah wa fil akhirati hasanah wa qina 'adzaban naar",
                "Ya Tuhan kami, berilah kami kebaikan di dunia dan kebaikan di akhirat dan peliharalah kami dari siksa neraka."));
    }

    private void initPrayerData() {
        prayerSteps = new ArrayList<>();

        // --- Data Niat 5 Waktu Lengkap ---
        List<PrayerStep.Niat> niatList = new ArrayList<>();
        niatList.add(new PrayerStep.Niat("Subuh",
                "أُصَلِّي فَرْضَ الصُّبْحِ رَكْعَتَيْنِ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
                "Ushallii fardhash-Shubhi rak’ataini mustaqbilal qiblati adaa’an lillaahi ta’aalaa.",
                "Aku niat sholat fardhu subuh dua rakaat menghadap kiblat karena Allah Ta'ala."));

        niatList.add(new PrayerStep.Niat("Dzuhur",
                "أُصَلِّي فَرْضَ الظُّهْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
                "Ushallii fardhazh-Zhuhri arba’a raka’aatin mustaqbilal qiblati adaa’an lillaahi ta’aalaa.",
                "Aku niat sholat fardhu dzuhur empat rakaat menghadap kiblat karena Allah Ta'ala."));

        niatList.add(new PrayerStep.Niat("Ashar",
                "أُصَلِّي فَرْضَ الْعَصْرِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
                "Ushallii fardhal ‘Ashri arba’a raka’aatin mustaqbilal qiblati adaa’an lillaahi ta’aalaa.",
                "Aku niat sholat fardhu ashar empat rakaat menghadap kiblat karena Allah Ta'ala."));

        niatList.add(new PrayerStep.Niat("Maghrib",
                "أُصَلِّي فَرْضَ الْمَغْرِبِ ثَلَاثَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
                "Ushallii fardhal Maghribi tsalaatsa raka’aatin mustaqbilal qiblati adaa’an lillaahi ta’aalaa.",
                "Aku niat sholat fardhu maghrib tiga rakaat menghadap kiblat karena Allah Ta'ala."));

        niatList.add(new PrayerStep.Niat("Isya",
                "أُصَلِّي فَرْضَ الْعِشَاءِ أَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ أَدَاءً لِلَّهِ تَعَالَى",
                "Ushallii fardhal ‘Isyaa’i arba’a raka’aatin mustaqbilal qiblati adaa’an lillaahi ta’aalaa.",
                "Aku niat sholat fardhu isya empat rakaat menghadap kiblat karena Allah Ta'ala."));

        // Step 1: Niat & Takbir
        prayerSteps.add(new PrayerStep(
                1,
                "1. Niat & Takbiratul Ihram",
                "Berdiri tegak menghadap kiblat, berniat dalam hati, lalu mengangkat kedua tangan sejajar telinga.",
                "اللهُ أَكْبَرُ",
                "Allahu Akbar",
                "Allah Maha Besar",
                R.drawable.img_takbir,
                niatList
        ));

        // Step 2: Iftitah
        prayerSteps.add(new PrayerStep(
                2,
                "2. Doa Iftitah (Sunnah)",
                "Membaca doa iftitah setelah takbiratul ihram dengan bersedekap.",
                "اللَّهُمَّ بَاعِدْ بَيْنِي وَبَيْنَ خَطَايَايَ كَمَا بَاعَدْتَ بَيْنَ الْمَشْرِقِ وَالْمَغْرِبِ، اللَّهُمَّ نَقِّنِي مِنْ خَطَايَايَ كَمَا يُنَقَّى الثَّوْبُ الْأَبْيَضُ مِنَ الدَّنَسِ، اللَّهُمَّ اغْسِلْنِي مِنْ خَطَايَايَ بِالْمَاءِ وَالثَّلْجِ وَالْبَرَدِ",
                "Allaahumma baa'id bainii wa baina khathaayaaya kamaa baa'adta bainal masyriqi wal maghrib. Allaahumma naqqinii min khathaayaaya kamaa yunaqqats tsaubul abyadhu minad danas. Allaahummaghsilnii min khathaayaaya bil maa-i wats tsalji wal barad.",
                "Ya Allah, jauhkanlah antara aku dan kesalahan-kesalahanku sebagaimana Engkau menjauhkan antara timur dan barat. Ya Allah, bersihkanlah aku dari kesalahan-kesalahanku sebagaimana baju putih dibersihkan dari kotoran. Ya Allah, cucilah aku dari kesalahan-kesalahanku dengan air, salju, dan embun.",
                R.drawable.img_iftitah,
                null
        ));


        prayerSteps.add(new PrayerStep(
                3,
                "3. Membaca Al-Fatihah",
                "Wajib dibaca pada setiap rakaat.",
                "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ (١) ٱلْحَمْدُ لِلَّهِ رَبِّ ٱلْعَٰلَمِينَ (٢) ٱلرَّحْمَٰنِ ٱلرَّحِيمِ (٣) مَٰلِكِ يَوْمِ ٱلدِّينِ (٤) إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ (٥) ٱهْدِنَا ٱلصِّرَٰطَ ٱلْمُسْتَقِيمَ (٦) صِرَٰطَ ٱلَّذِينَ أَنْعَمْتَ عَلَيْهِمْ غَيْرِ ٱلْمَغْضُوبِ عَلَيْهِمْ وَلَا ٱلضَّآلِّينَ (٧)",
                "Bismillaahirrahmaanirrahiim. Alhamdulillahi rabbil 'aalamiin. Arrahmaanirrahiim. Maaliki yaumiddiin. Iyyaaka na'budu wa iyyaaka nasta'iin. Ihdinash shiraathal mustaqiim. Shiraathal ladziina an'amta 'alaihim ghairil maghdhuubi 'alaihim waladh-dhaalliin.",
                "Dengan menyebut nama Allah Yang Maha Pemurah lagi Maha Penyayang. Segala puji bagi Allah, Tuhan semesta alam. Maha Pemurah lagi Maha Penyayang. Yang menguasai di Hari Pembalasan. Hanya Engkaulah yang kami sembah, dan hanya kepada Engkaulah kami meminta pertolongan. Tunjukilah kami jalan yang lurus, (yaitu) Jalan orang-orang yang telah Engkau beri nikmat kepada mereka; bukan (jalan) mereka yang dimurkai dan bukan (pula jalan) mereka yang sesat.",
                R.drawable.img_alfatihah,
                null
        ));


        prayerSteps.add(new PrayerStep(
                4,
                "4. Membaca Surat Pendek (Sunnah)",
                "Disunnahkan membaca ayat atau surat pendek Al-Quran setelah Al-Fatihah pada dua rakaat pertama. Contoh: Surat Al-Ikhlas.",
                "قُلْ هُوَ اللَّهُ أَحَدٌ (١) اللَّهُ الصَّمَدُ (٢) لَمْ يَلِدْ وَلَمْ يُولَدْ (٣) وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ (٤)",
                "Qul huwallaahu ahad. Allaahush-shamad. Lam yalid wa lam yuulad. Wa lam yakul lahuu kufuwan ahad.",
                "Katakanlah: Dialah Allah, Yang Maha Esa. Allah adalah Tuhan yang bergantung kepada-Nya segala sesuatu. Dia tiada beranak dan tidak pula diperanakkan, dan tidak ada seorangpun yang setara dengan Dia.",
                R.drawable.img_surat,
                null
        ));


        prayerSteps.add(new PrayerStep(
                5,
                "5. Ruku'",
                "Membungkuk hingga punggung rata, tangan memegang lutut.",
                "سُبْحَانَ رَبِّيَ الْعَظِيمِ وَبِحَمْدِهِ",
                "Subhaana rabbiyal 'azhiimi wa bihamdih (3x)",
                "Maha Suci Tuhanku Yang Maha Agung dan dengan segala puji bagi-Nya.",
                R.drawable.img_ruku,
                null
        ));

        prayerSteps.add(new PrayerStep(
                6,
                "6. I'tidal",
                "Bangkit dari ruku' dan berdiri tegak (tuma'ninah).",
                "سَمِعَ اللهُ لِمَنْ حَمِدَهُ . رَبَّنَا لَكَ الْحَمْدُ مِلْءُ السَّمَاوَاتِ وَمِلْءُ الْأَرْضِ وَمِلْءُ مَا شِئْتَ مِنْ شَيْءٍ بَعْدُ",
                "Sami'allahu liman hamidah. Rabbanaa lakal hamdu mil-us samaawati wa mil-ul ardhi wa mil-u maa syi'ta min syai-in ba'du.",
                "Allah Maha Mendengar orang yang memuji-Nya. Ya Tuhan kami, segala puji bagi-Mu, sepenuh langit dan sepenuh bumi, dan sepenuh apa yang Engkau kehendaki dari sesuatu setelahnya.",
                R.drawable.img_itidal,
                null
        ));


        prayerSteps.add(new PrayerStep(
                7,
                "7. Sujud",
                "Meletakkan dahi, kedua telapak tangan, lutut, dan jari kaki ke lantai.",
                "سُبْحَانَ رَبِّيَ الْأَعْلَى وَبِحَمْدِهِ",
                "Subhaana rabbiyal a'laa wa bihamdih (3x)",
                "Maha Suci Tuhanku Yang Maha Tinggi dan dengan segala puji bagi-Nya.",
                R.drawable.img_sujud,
                null
        ));


        prayerSteps.add(new PrayerStep(
                8,
                "8. Duduk Diantara Dua Sujud",
                "Duduk iftirasy (menduduki kaki kiri, kaki kanan tegak).",
                "رَبِّ اغْفِرْ لِي وَارْحَمْنِي وَاجْبُرْنِي وَارْفَعْنِي وَارْزُقْنِي وَاهْدِنِي وَعَافِنِي وَاعْفُ عَنِّي",
                "Rabbighfirlii warhamnii wajburnii warfa'nii warzuqnii wahdinii wa'aafinii wa'fu 'annii",
                "Ya Tuhanku, ampunilah aku, kasihanilah aku, cukupkanlah kekuranganku, angkatlah derajatku, berilah aku rezeki, berilah aku petunjuk, berilah aku kesehatan, dan maafkanlah aku.",
                R.drawable.img_duduk,
                null
        ));


        prayerSteps.add(new PrayerStep(
                9,
                "9. Tahiyat Awal",
                "Duduk iftirasy pada rakaat kedua, membaca tasyahud dan shalawat nabi.",
                "التَّحِيَّاتُ الْمُبَارَكَاتُ الصَّلَوَاتُ الطَّيِّبَاتُ لِلَّهِ، السَّلَامُ عَلَيْكَ أَيُّهَا النَّبِيُّ وَرَحْمَةُ اللهِ وَبَرَكَاتُهُ، السَّلَامُ عَلَيْنَا وَعَلَى عِبَادِ اللهِ الصَّالِحِينَ. أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا اللهُ وَأَشْهَدُ أَنَّ مُحَمَّدًا رَسُولُ اللهِ. اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ",
                "Attahiyyaatul mubaarakaatush shalawaatuth thayyibaatu lillaah. Assalaamu 'alaika ayyuhan nabiyyu wa rahmatullaahi wa barakaatuh. Assalaamu 'alainaa wa 'alaa 'ibaadillaahish shaalihiin. Asyhadu allaa ilaaha illallaah, wa asyhadu anna Muhammadar rasuulullaah. Allaahumma shalli 'alaa Sayyidinaa Muhammad.",
                "Segala kehormatan, keberkahan, shalawat dan kebaikan adalah milik Allah. Semoga keselamatan, rahmat Allah dan berkah-Nya tercurah kepadamu wahai Nabi. Semoga keselamatan tercurah kepada kami dan kepada hamba-hamba Allah yang shaleh. Aku bersaksi bahwa tidak ada Tuhan selain Allah, dan aku bersaksi bahwa Muhammad adalah utusan Allah. Ya Allah, limpahkanlah rahmat kepada Nabi Muhammad.",
                R.drawable.img_tahiyat_awal,
                null
        ));


        prayerSteps.add(new PrayerStep(
                10,
                "10. Tahiyat Akhir & Salam",
                "Duduk tawarruk pada rakaat terakhir, membaca tasyahud lengkap, shalawat ibrahimiyah, dan salam.",
                "التَّحِيَّاتُ الْمُبَارَكَاتُ الصَّلَوَاتُ الطَّيِّبَاتُ لِلَّهِ... (lanjutan)... اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِ سَيِّدِنَا مُحَمَّدٍ، كَمَا صَلَّيْتَ عَلَى سَيِّدِنَا إِبْرَاهِيمَ وَعَلَى آلِ سَيِّدِنَا إِبْرَاهِيمَ، وَبَارِكْ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِ سَيِّدِنَا مُحَمَّدٍ، كَمَا بَارَكْتَ عَلَى سَيِّدِنَا إِبْرَاهِيمَ وَعَلَى آلِ سَيِّدِنَا إِبْرَاهِيمَ، فِي الْعَالَمِينَ إِنَّكَ حَمِيدٌ مَجِيدٌ. السَّلاَمُ عَلَيْكُمْ وَرَحْمَةُ اللهِ",
                "...Allaahumma shalli 'alaa Sayyidinaa Muhammad wa 'alaa aali Sayyidinaa Muhammad, kamaa shallaita 'alaa Sayyidinaa Ibraahiim wa 'alaa aali Sayyidinaa Ibraahiim, wa baarik 'alaa Sayyidinaa Muhammad wa 'alaa aali Sayyidinaa Muhammad, kamaa baarakta 'alaa Sayyidinaa Ibraahiim wa 'alaa aali Sayyidinaa Ibraahiim, fil 'aalamiina innaka hamiidum majiid. Assalaamu 'alaikum wa rahmatullaah.",
                "...Ya Allah, limpahkanlah rahmat kepada Nabi Muhammad dan keluarga Nabi Muhammad, sebagaimana Engkau telah melimpahkan rahmat kepada Nabi Ibrahim dan keluarga Nabi Ibrahim. Dan berkahilah Nabi Muhammad dan keluarga Nabi Muhammad, sebagaimana Engkau telah memberkahi Nabi Ibrahim dan keluarga Nabi Ibrahim. Sesungguhnya di alam semesta ini Engkau Maha Terpuji lagi Maha Mulia. Semoga keselamatan dan rahmat Allah terlimpah kepadamu.",
                R.drawable.img_tahiyat_akhir,
                null
        ));
    }
}