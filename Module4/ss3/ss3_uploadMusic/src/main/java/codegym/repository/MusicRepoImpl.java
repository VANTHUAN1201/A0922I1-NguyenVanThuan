package codegym.repository;

import codegym.model.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepoImpl implements IMusicRepo {
    private static List<Music> musicList;
    static {
        musicList = new ArrayList<>();
        musicList.add(new Music("Cô ấy của anh ấy","Bảo anh","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/co-ay-cua-anh-ay-bao-anh.G5It0PmyrBog.html"));
        musicList.add(new Music("Chờ trông ai","Hồ Phi Nal","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/cho-trong-ai-nal.es9umRjzTxNQ.html"));
        musicList.add(new Music("Dang dở","Hồ Phi Nal","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/dang-do-nal.0hx9ScYCzNQ6.html"));
        musicList.add(new Music("Thành phố buồn","Mạnh Quỳnh","Bolero","https://www.nhaccuatui.com/bai-hat/thanh-pho-buon-manh-quynh.2Gb3PLm03VPk.html"));
        musicList.add(new Music("Khóc cho người đi","Đàm Vĩnh Hưng","Bolero","https://www.nhaccuatui.com/bai-hat/khoc-cho-nguoi-di-dam-vinh-hung.Er1OcjhmCjad.html"));
        }
    @Override
    public List<Music> findAll() {
        return musicList;
    }

    @Override
    public void save(Music music) {
        musicList.add(music);
    }
}
