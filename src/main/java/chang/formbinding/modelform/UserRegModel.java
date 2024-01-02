package chang.formbinding.modelform;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegModel {
    private String username;
    private String email;
    private String mobile;
    private String passwd;
}
