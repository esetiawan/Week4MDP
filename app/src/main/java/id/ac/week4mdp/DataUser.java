package id.ac.week4mdp;

import android.os.Parcel;
import android.os.Parcelable;

public class DataUser implements Parcelable {
    public DataUser(String email, String date) {
        this.email = email;
        this.date = date;
    }
    private String email,date;

    protected DataUser(Parcel in) {
        email = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataUser> CREATOR = new Creator<DataUser>() {
        @Override
        public DataUser createFromParcel(Parcel in) {
            return new DataUser(in);
        }

        @Override
        public DataUser[] newArray(int size) {
            return new DataUser[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DataUser{" +
                "email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
