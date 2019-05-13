import { InvoiceDetailDto } from "./invoiceDetailDto.model";

export class InvoiceDto {
    idClient: number;
    idWaiter: number;
    idTable: number;
    invoiceDetailDtos: InvoiceDetailDto[];
}