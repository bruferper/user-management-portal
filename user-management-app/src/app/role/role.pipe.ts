import { Pipe, PipeTransform } from "@angular/core";
import { IRole } from "./role.model";

@Pipe({
    name: 'rolesNamePipe',
    standalone: true,
  })
  export class RolesNamePipe implements PipeTransform {
    /**
     * @param value The arrays of roles to transform to string with role name.
     */
    transform(value: IRole[]): string;
    transform(value: null | undefined): null;
    transform(value: IRole[] | null | undefined): string | null;
    transform(value: IRole[] | null | undefined): string | null {
      if (value == null) return null;
      return value.map((r) => r.name).join(", ");
    }
}
