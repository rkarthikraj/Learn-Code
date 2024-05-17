package others;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class URLSplitter {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");
        String url = "https://abc.com:3306/query/CPD_v2_1/Create_duns_details?&site_duns=691730089&GDUNSIndc=N&SiteStatusIndc=1&SubsidiaryIndc=3&CreatedByAppName=bqa&CreatedDateTime=2024-02-06 05:48:21&UpdatedDateTime=2024-02-06 10:28:47&LastUpdatedByAppName=bqa&Name=BOFA SECURITIES JAPAN CO., LTD.&OriginalRecordSource=CASTLE&Status=&CreatedByEmail=bqa@dell.com&CreatedByNTID=&LastUpdatedByEmail=&LastUpdatedByNTID=&OutOfBusinessIndicator=active&Website=&UCID=1000278584&SourceAddressGUIDValue=1-4-1 NIHONBASHI, BLDG CHOME BLDG 14F ,CHUO-KU,TOKYO,103-0027,JP&AddressLine1=1-4-1 NIHONBASHI&AddressLine2= BLDG CHOME BLDG 14F &AddressLine3=&AddressLine4=&City=CHUO-KU&CountyName=&FullAddress=1-4-1 NIHONBASHI, BLDG CHOME BLDG 14F ,CHUO-KU,TOKYO,103-0027,JP&GeoCode=&ZipCode=103-0027&DNBAddressGUIDValue=1-4-1, NIHOMBASHI,NIHOMBASHI ITCHOME MITSUI BLDG.,CHUO-KU,TKY,103-0027,JP&DNBAddressLine1=1-4-1, NIHOMBASHI&DNBAddressLine2=NIHOMBASHI ITCHOME MITSUI BLDG.&DNBAddressLine3=&DNBAddressLine4=&DNBCity=CHUO-KU&DNBCountyName=&DNBFullAddress=1-4-1, NIHOMBASHI,NIHOMBASHI ITCHOME MITSUI BLDG.,CHUO-KU,TKY,103-0027,JP&DNBGeoCode=+139.771345_+35.685866&verifiedAVS=False&verifiedDQ_Address=False&DNBZipCode=103-0027&StateCountryCode=TOKYO_JP&CountryName=JP&CountryISOCode=JP&StateCode=TOKYO&StateName=&DnbStateCountryCode=TOKYO_JP&DnbCountryName=JP&DnbCountryISOCode=JP&DnbStateCode=TKY&DnbStateName=&CustomerFullName=BOFA SECURITIES JAPAN CO., LTD.&AlternateName=&VerifiedDQ_Name=False&DnbCustomerFullName=BOFA SECURITIES JAPAN CO., LTD.&Dnb_phone=&Extension=&CountryCode=&PhoneType=EWP&OrgProfileId=11279&VCID=40861710233124&Description=Testing updating description&PartyID=5661517&RestrictedSite=0&OrgProfile_Status=Active&ProfileType=OPEN&CompanyProfileName=MERRILL LYNCH JAPAN SECURITIES CO., LTD.&Domains=blackrock.com&Domains=exchange.japan.ml.com";
        String[] tokens = url.split("&");
        LinkedHashMap<String, List<String>> linkedHM = new LinkedHashMap<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].contains("=")) {
                String[] keyValue = tokens[i].split("=");
//                System.out.println(keyValue[0] + " -> " + (keyValue.length == 2 ? keyValue[1] : ""));
                List<String> list = linkedHM.get(keyValue[0]);
                if (list == null) {
                    list = new ArrayList();
                    linkedHM.put(keyValue[0], list);
                }
                list.add((keyValue.length == 2 ? keyValue[1] : ""));
            }
        }

        Set<String> keys = linkedHM.keySet();
        StringBuilder finalUrl = new StringBuilder();
        for (String key : keys) {
            List<String> values = linkedHM.get(key);
            String keyValue = "";
            for (int i = 0; i < values.size(); i++) {
                keyValue = key + "=" + values.get(i);
                //System.out.println(keyValue);
                finalUrl.append(keyValue).append("&");
            }
        }
        System.out.println(finalUrl.toString());
    }
}
