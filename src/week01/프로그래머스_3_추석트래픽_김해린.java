package week01;

public class 프로그래머스_3_추석트래픽_김해린 {
    public static void main(String[] args) {
        String lines[] = {"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(lines));
    }


    public static int solution(String[] lines) {
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];
        getTimes(lines, startTimes, endTimes);
        int answer = 0;
        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int start = startTimes[i];
            int end = start + 1000;
            for (int j = 0; j < lines.length; j++) {
                if (startTimes[j] >= start && startTimes[j] < end) {
                    cnt++;
                } else if (endTimes[j] >= start && endTimes[j] < end) {
                    cnt++;
                } else if (startTimes[j] <= start && endTimes[j] >= end) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int start = endTimes[i];
            int end = start + 1000;
            for (int j = 0; j < lines.length; j++) {
                if (startTimes[j] >= start && startTimes[j] < end) {
                    cnt++;
                } else if (endTimes[j] >= start && endTimes[j] < end) {
                    cnt++;
                } else if (startTimes[j] <= start && endTimes[j] >= end) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < lines.length; i++) {
            String log[] = lines[i].split(" "); //"날짜, 응답 완료 시간, 처리 시간"
            String time[] = log[1].split(":"); //"시 분 초"
            int hour = Integer.parseInt(time[0]) * 60 * 60 * 1000;
            int min = Integer.parseInt(time[1]) * 60 * 1000;
            int sec = (int) (Double.parseDouble(time[2]) * 1000);
            int endTime = hour + min + sec;

            int processingTime = (int) (Double.parseDouble(log[2].replace("s", "")) * 1000);
            int startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
