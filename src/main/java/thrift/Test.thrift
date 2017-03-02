namespace java com.winwill.thrift

enum RequestType {
    SAY_HELLO,   //�ʺ�
    QUERY_TIME,  //ѯ��ʱ��
}

struct Request {
    1: required RequestType type;  // ��������ͣ���ѡ
    2: required string name;       // ����������˵����֣���ѡ
    3: optional i32 age;           // ����������˵����䣬��ѡ
}

exception RequestException {
    1: required i32 code;
    2: optional string reason;
}

// ������
service HelloWordService {
    string doAction(1: Request request) throws (1:RequestException qe); // �����׳��쳣��
}