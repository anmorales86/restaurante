
import { HttpErrorResponse } from '@angular/common/http';

export class ErrorResponse {

code: string;
message: string;


constructor(err: HttpErrorResponse) {
    this.code = err !== null ? err.error.code : '';
    this.message = err !== null ? err.error.message : '';

}
}