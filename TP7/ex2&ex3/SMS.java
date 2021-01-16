public class SMS {
    String subject, phone_number, recieve_number, type, content, status;

    public SMS() {

    }

    public SMS(String subject, String phone_number, String recieve_number, String type, String content, String status) {
        this.subject = subject;
        this.phone_number = checkPhoneNumber(phone_number);
        this.recieve_number = checkPhoneNumber(recieve_number);
        this.content = content;
        if (type.equalsIgnoreCase("Text") || type.equalsIgnoreCase("MMS"))
            this.type = type;
        if (status.equalsIgnoreCase("read") || status.equalsIgnoreCase("new"))
            this.status = status;
    }

    @Override
    public String toString() {
        return "subject:" + subject + "\t" + "phone number:" + phone_number + "\t" + "recieve number:" + recieve_number
                + "\t" + "type of message:" + type + "\t" + "content:" + content + "\t" + "status:" + "\t" + status
                + "\n\n";
    }

    public String getSubject() {
        return subject;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getRecieveNumber() {
        return recieve_number;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    private String checkPhoneNumber(String phonenumber) {
        int i = 0;
        for (int j = 0; j < phonenumber.length(); j++) {
            if (phonenumber.charAt(j)>='0'&& phonenumber.charAt(j)<='9') {
                i = 1;
            } else
                i = 0;
        }
        if (i == 0) {
            return null;
        } else {
            return phonenumber;
        }
    }
}
