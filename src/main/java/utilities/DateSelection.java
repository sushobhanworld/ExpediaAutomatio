package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateSelection
{
    private static long DateDifferenceInDays(String futureDate) throws ParseException {
        Date date1= new Date();
        Date date2;

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MM/dd/yyyy");
        date2= simpleDateFormat.parse(futureDate);
        return ChronoUnit.DAYS.between(date1.toInstant(), date2.toInstant());
    }

    public static String GetStartDate(String futureStartDate) throws ParseException {
        Date date= new Date();
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, (int)DateDifferenceInDays(futureStartDate));
        Date date1= calendar.getTime();
        String startDate= date1.toString();
        String[] s=startDate.split(" ");
        String requiredStartDate= "";
        if(Integer.valueOf(s[2])>9)
        {
            requiredStartDate= s[1]+" "+s[2]+","+" "+s[5];
        }
        else
        {
            String[] s21= s[2].split("");
            String q= s21[1];
            requiredStartDate= s[1]+" "+q+","+" "+s[5];
        }
        System.out.println("S date: "+requiredStartDate);
        return requiredStartDate;
    }

    public static String GetReturnDate(String futureReturnDate) throws ParseException {
        Date date= new Date();
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, (int)DateDifferenceInDays(futureReturnDate));
        Date date1= calendar.getTime();
        String returnDate= date1.toString();
        String[] s=returnDate.split(" ");
        String requiredReturnDate= "";
        if(Integer.valueOf(s[2])>9)
        {
            requiredReturnDate= s[1]+" "+s[2]+","+" "+s[5];
        }
        else
        {
            String[] s21= s[2].split("");
            String q= s21[1];
            requiredReturnDate= s[1]+" "+q+","+" "+s[5];
        }
        System.out.println("S date: "+requiredReturnDate);
        return requiredReturnDate;
    }
}
