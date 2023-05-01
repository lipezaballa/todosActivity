import { Pipe, PipeTransform } from "@angular/core";
import { Todo } from "./todo.service";

@Pipe({
    name: "filterBy",
})
export class FilterByPipe implements PipeTransform {
    transform(todos: Todo[], search: string): Todo[] {
        if (!search) {
            return todos;
        }

        const searchText = search.toLowerCase();
        const todoFiltered = todos.filter((todo) =>
            todo.task.toLowerCase().includes(searchText)
        );
        return todoFiltered;
    }
}
