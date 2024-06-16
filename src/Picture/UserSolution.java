package Picture;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UserSolution {
    private HashMap<String, Category> categories;
    private ArrayDeque<Picture> pictures;
    public static class Picture implements Comparable<Picture>{
        public int id;
        public long time; // 这里是时间戳
        public ArrayList<Category> categories = new ArrayList<>(); // 属于哪个分类，这是当时的我没有想到的

        @Override
        public int compareTo(Picture o) {
            return Long.compare(this.time, o.time);
        }
    }
    public static class Category extends ArrayList<Picture> {};

    void init(int N, String[] pictureList)
    {
        categories = new HashMap<>();
        pictures = new ArrayDeque<>();
        savePictures(N, pictureList);
    }

    void savePictures(int M, String[] pictureList)
    {
        ArrayList<Picture> list = new ArrayList<>();   // 在这或许可以优化为优先队列？
        for (int i = 0;i < M;i ++) {
            list.add(parese(pictureList[i]));
        }
        Collections.sort(list);
        for (Picture p : list) {
            pictures.add(p);
            for (Category c : p.categories) {
                c.add(p);
            }
        }
    }

    /**
     * 这一块要好好看看，why？
     * @param s
     * @return
     */
    public Picture parese(String s) {
        Picture newPic = new Picture();
        String[] parts = s.split(",[A-Z]]"); // 正则分割
        newPic.id = pareseInt(parts[0], 4);
        for (int i = 4;i < parts[1].length() - 1;i ++) {  //这个循环也不是很懂
            if (!Character.isDigit(parts[1].charAt(i))) continue;
            newPic.time = newPic.time * 100 + pareseInt(parts[1], i + 1);
        }
        newPic.categories.add(getCatgory(parts[2], 3));
        for (int i = 6;i < parts[3].length();i ++ ){
            if (Character.isAlphabetic(parts[3].charAt(i))) continue;
            newPic.categories.add(getCatgory(parts[3], i + 1));
        }
        return newPic;

    }
    public Category getCatgory(String s, int idx) {
        for (int i = idx + 1;i < s.length();i ++) {
            if (Character.isAlphabetic(s.charAt(i))) continue;
            String substring = s.substring(idx, i);
            return categories.computeIfAbsent(substring, k -> new Category());
        }
        return null;
    }
    public int pareseInt(String input, int idx) {
        int result = 0;
        for (int i = idx ;i < input.length();i ++) {  // 这个循环不懂
            if (!Character.isDigit(input.charAt(i)))    break;
            result = result * 10 + input.charAt(i) - '0';
        }
        return result;
    }

    int filterPictures(String mFilter, int K)
    {
        int index = mFilter.charAt(0) == 'L' ? 4 : 8;
        Category catgory = getCatgory(mFilter, index);
        return catgory.get(catgory.size() - K).id;
    }

    int deleteOldest()
    {
        return pictures.pollFirst().id;
    }
}
