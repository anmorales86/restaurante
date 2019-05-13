package com.group.restaurante.dao.util;

import com.group.restaurante.core.dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anderson Q. on 11/05/2019.
 */
public class Util {

    public static List<ClientDto> resetToListClientDto(Object[] data) {
        List<ClientDto> clientDtoList = new ArrayList<>();
        ClientDto clientDto;
        for (int i=0;i<data.length;i++) {
            clientDto = new ClientDto();
            Object[] info = (Object[]) data[i];
            clientDto.setIdClient(Long.parseLong(String.valueOf(info[0])));
            clientDto.setName(String.valueOf(info[1]));
            clientDto.setLastName1(String.valueOf(info[2]));
            clientDto.setLastName2(info[3] != null ? String.valueOf(info[3]) : null);
            clientDto.setComment(info[4] != null ? String.valueOf(info[4]) : null);
            clientDtoList.add(clientDto);
        }
        return clientDtoList.size() > 0 ? clientDtoList : null;
    }

    public static List<ChefDto> resetToListChefDto(Object[] data) {
        List<ChefDto> chefDtoList = new ArrayList<>();
        ChefDto chefDto;
        for (int i=0;i<data.length;i++) {
            chefDto = new ChefDto();
            Object[] info = (Object[]) data[i];
            chefDto.setIdChef(Long.parseLong(String.valueOf(info[0])));
            chefDto.setName(String.valueOf(info[1]));
            chefDto.setLastName1(String.valueOf(info[2]));
            chefDto.setLastName2(info[3] != null ? String.valueOf(info[3]) : null);

            chefDtoList.add(chefDto);
        }
        return chefDtoList.size() > 0 ? chefDtoList : null;
    }

    public static List<WaiterDto> resetToListWaiterDto(Object[] data) {
        List<WaiterDto> waiterDtoList = new ArrayList<>();
        WaiterDto waiterDto;
        for (int i=0;i<data.length;i++) {
            waiterDto = new WaiterDto();
            Object[] info = (Object[]) data[i];
            waiterDto.setIdWaiter(Long.parseLong(String.valueOf(info[0])));
            waiterDto.setName(String.valueOf(info[1]));
            waiterDto.setLastName1(String.valueOf(info[2]));
            waiterDto.setLastName2(info[3] != null ? String.valueOf(info[3]) : null);

            waiterDtoList.add(waiterDto);
        }
        return waiterDtoList.size() > 0 ? waiterDtoList : null;
    }

    public static List<TableDto> resetToListTableDto(Object[] data) {
        List<TableDto> tableDtoList = new ArrayList<>();
        TableDto tableDto;
        for (int i=0;i<data.length;i++) {
            tableDto = new TableDto();
            Object[] info = (Object[]) data[i];
            tableDto.setIdTable(Long.parseLong(String.valueOf(info[0])));
            tableDto.setMaxComensaNumber(Long.parseLong(String.valueOf(info[1])));
            tableDto.setLocation(String.valueOf(info[2]));


            tableDtoList.add(tableDto);
        }
        return tableDtoList.size() > 0 ? tableDtoList : null;
    }

    public static List<ReportWaiterDto> resetToListReportWaiterDto(Object[] data) {
        List<ReportWaiterDto> tableDtoList = new ArrayList<>();
        ReportWaiterDto reportWaiterDto;
        for (int i=0;i<data.length;i++) {
            reportWaiterDto = new ReportWaiterDto();
            Object[] info = (Object[]) data[i];
            reportWaiterDto.setName(String.valueOf(info[0]));
            reportWaiterDto.setDate(String.valueOf(info[1]));
            reportWaiterDto.setTotal(Long.parseLong(String.valueOf(info[2])));


            tableDtoList.add(reportWaiterDto);
        }
        return tableDtoList.size() > 0 ? tableDtoList : null;
    }

    public static List<ReportClientDto> resetToListReportClientDto(Object[] data) {
        List<ReportClientDto> tableDtoList = new ArrayList<>();
        ReportClientDto reportClientDto;
        for (int i=0;i<data.length;i++) {
            reportClientDto = new ReportClientDto();
            Object[] info = (Object[]) data[i];
            reportClientDto.setName(String.valueOf(info[0]));
            tableDtoList.add(reportClientDto);
        }
        return tableDtoList.size() > 0 ? tableDtoList : null;
    }

}
