package puzzle.defibrillators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 1002486 on 2017. 9. 11..
 */
class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    String LON = in.next();
    String LAT = in.next();
    int N = in.nextInt();
    if (in.hasNextLine()) {
      in.nextLine();
    }
    List<Defibrillator> defs = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String DEFIB = in.nextLine();
      try {
        defs.add(new Defibrillator(DEFIB));
      } catch (Exception e) {
        System.err.println("생성 실패!!!");
      }
    }

    double longtitude = Double.parseDouble(LON.replace(",", "."));
    double latitude = Double.parseDouble(LAT.replace(",", "."));

    Defibrillator closeDefib = null;
    double closeDistance = 0;
    for (Defibrillator def : defs) {
      if (closeDefib == null) {
        closeDefib = def;
        closeDistance = def.distance(longtitude, latitude);
        continue;
      }
      double distance = def.distance(longtitude, latitude);
      if (closeDistance > distance) {
        closeDistance = distance;
        closeDefib = def;
      }
    }

    System.out.println(closeDefib.getName());
  }
}

class Defibrillator {
  private Long id;
  private String name;
  private String address;
  private String phoneNumber;
  private double longitude;
  private double latitude;

  public Defibrillator(String defib) throws Exception {
    String[] split = defib.split(";");
    if (split.length < 6) {
      throw new Exception("요소가 부족합니다.");
    }
    this.id = Long.valueOf(split[0]);
    this.name = split[1];
    this.address = split[2];
    this.phoneNumber = split[3];
    this.longitude = Double.parseDouble(split[4].replace(",", "."));
    this.latitude = Double.parseDouble(split[5].replace(",", "."));
  }

  public double distance(double longitude, double latitude) {
    double x = (longitude - this.longitude) * Math.cos((this.latitude + latitude) / 2);
    double y = latitude - this.latitude;
    double d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 6371;
    return d;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
}