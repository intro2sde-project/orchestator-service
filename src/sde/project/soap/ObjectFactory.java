
package sde.project.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sde.project.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdateBeer_QNAME = new QName("http://soap.project.sde/", "updateBeer");
    private final static QName _ReadUserWLResponse_QNAME = new QName("http://soap.project.sde/", "readUserWLResponse");
    private final static QName _Beer_QNAME = new QName("http://soap.project.sde/", "Beer");
    private final static QName _ReadBeerResponse_QNAME = new QName("http://soap.project.sde/", "readBeerResponse");
    private final static QName _ReadBeerListResponse_QNAME = new QName("http://soap.project.sde/", "readBeerListResponse");
    private final static QName _ReadUser_QNAME = new QName("http://soap.project.sde/", "readUser");
    private final static QName _DeleteBeerResponse_QNAME = new QName("http://soap.project.sde/", "deleteBeerResponse");
    private final static QName _GetUserRecom_QNAME = new QName("http://soap.project.sde/", "getUserRecom");
    private final static QName _ReadUserListResponse_QNAME = new QName("http://soap.project.sde/", "readUserListResponse");
    private final static QName _AddUserView_QNAME = new QName("http://soap.project.sde/", "addUserView");
    private final static QName _GetBeerRatingUser_QNAME = new QName("http://soap.project.sde/", "getBeerRatingUser");
    private final static QName _DeleteBeer_QNAME = new QName("http://soap.project.sde/", "deleteBeer");
    private final static QName _CreateBeer_QNAME = new QName("http://soap.project.sde/", "createBeer");
    private final static QName _RateUserBeerResponse_QNAME = new QName("http://soap.project.sde/", "rateUserBeerResponse");
    private final static QName _ReadUserResponse_QNAME = new QName("http://soap.project.sde/", "readUserResponse");
    private final static QName _CreateBeerResponse_QNAME = new QName("http://soap.project.sde/", "createBeerResponse");
    private final static QName _ReadUserWL_QNAME = new QName("http://soap.project.sde/", "readUserWL");
    private final static QName _RemoveBeerToUser_QNAME = new QName("http://soap.project.sde/", "removeBeerToUser");
    private final static QName _GetBeerRatingUserResponse_QNAME = new QName("http://soap.project.sde/", "getBeerRatingUserResponse");
    private final static QName _AddBeerToUserResponse_QNAME = new QName("http://soap.project.sde/", "addBeerToUserResponse");
    private final static QName _ReadBeerList_QNAME = new QName("http://soap.project.sde/", "readBeerList");
    private final static QName _CreateUserResponse_QNAME = new QName("http://soap.project.sde/", "createUserResponse");
    private final static QName _ReadBeer_QNAME = new QName("http://soap.project.sde/", "readBeer");
    private final static QName _AddUserViewResponse_QNAME = new QName("http://soap.project.sde/", "addUserViewResponse");
    private final static QName _ReadUserList_QNAME = new QName("http://soap.project.sde/", "readUserList");
    private final static QName _RateUserBeer_QNAME = new QName("http://soap.project.sde/", "rateUserBeer");
    private final static QName _UpdateBeerResponse_QNAME = new QName("http://soap.project.sde/", "updateBeerResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://soap.project.sde/", "deleteUserResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://soap.project.sde/", "deleteUser");
    private final static QName _CreateUser_QNAME = new QName("http://soap.project.sde/", "createUser");
    private final static QName _RemoveBeerToUserResponse_QNAME = new QName("http://soap.project.sde/", "removeBeerToUserResponse");
    private final static QName _Person_QNAME = new QName("http://soap.project.sde/", "person");
    private final static QName _AddBeerToUser_QNAME = new QName("http://soap.project.sde/", "addBeerToUser");
    private final static QName _GetUserRecomResponse_QNAME = new QName("http://soap.project.sde/", "getUserRecomResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sde.project.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Beer }
     * 
     */
    public Beer createBeer() {
        return new Beer();
    }

    /**
     * Create an instance of {@link Beer.Rating }
     * 
     */
    public Beer.Rating createBeerRating() {
        return new Beer.Rating();
    }

    /**
     * Create an instance of {@link ReadUserListResponse }
     * 
     */
    public ReadUserListResponse createReadUserListResponse() {
        return new ReadUserListResponse();
    }

    /**
     * Create an instance of {@link GetUserRecom }
     * 
     */
    public GetUserRecom createGetUserRecom() {
        return new GetUserRecom();
    }

    /**
     * Create an instance of {@link DeleteBeerResponse }
     * 
     */
    public DeleteBeerResponse createDeleteBeerResponse() {
        return new DeleteBeerResponse();
    }

    /**
     * Create an instance of {@link ReadBeerListResponse }
     * 
     */
    public ReadBeerListResponse createReadBeerListResponse() {
        return new ReadBeerListResponse();
    }

    /**
     * Create an instance of {@link ReadUser }
     * 
     */
    public ReadUser createReadUser() {
        return new ReadUser();
    }

    /**
     * Create an instance of {@link ReadUserWLResponse }
     * 
     */
    public ReadUserWLResponse createReadUserWLResponse() {
        return new ReadUserWLResponse();
    }

    /**
     * Create an instance of {@link UpdateBeer }
     * 
     */
    public UpdateBeer createUpdateBeer() {
        return new UpdateBeer();
    }

    /**
     * Create an instance of {@link ReadBeerResponse }
     * 
     */
    public ReadBeerResponse createReadBeerResponse() {
        return new ReadBeerResponse();
    }

    /**
     * Create an instance of {@link RemoveBeerToUser }
     * 
     */
    public RemoveBeerToUser createRemoveBeerToUser() {
        return new RemoveBeerToUser();
    }

    /**
     * Create an instance of {@link ReadUserWL }
     * 
     */
    public ReadUserWL createReadUserWL() {
        return new ReadUserWL();
    }

    /**
     * Create an instance of {@link CreateBeerResponse }
     * 
     */
    public CreateBeerResponse createCreateBeerResponse() {
        return new CreateBeerResponse();
    }

    /**
     * Create an instance of {@link CreateBeer }
     * 
     */
    public CreateBeer createCreateBeer() {
        return new CreateBeer();
    }

    /**
     * Create an instance of {@link RateUserBeerResponse }
     * 
     */
    public RateUserBeerResponse createRateUserBeerResponse() {
        return new RateUserBeerResponse();
    }

    /**
     * Create an instance of {@link ReadUserResponse }
     * 
     */
    public ReadUserResponse createReadUserResponse() {
        return new ReadUserResponse();
    }

    /**
     * Create an instance of {@link GetBeerRatingUser }
     * 
     */
    public GetBeerRatingUser createGetBeerRatingUser() {
        return new GetBeerRatingUser();
    }

    /**
     * Create an instance of {@link AddUserView }
     * 
     */
    public AddUserView createAddUserView() {
        return new AddUserView();
    }

    /**
     * Create an instance of {@link DeleteBeer }
     * 
     */
    public DeleteBeer createDeleteBeer() {
        return new DeleteBeer();
    }

    /**
     * Create an instance of {@link RateUserBeer }
     * 
     */
    public RateUserBeer createRateUserBeer() {
        return new RateUserBeer();
    }

    /**
     * Create an instance of {@link UpdateBeerResponse }
     * 
     */
    public UpdateBeerResponse createUpdateBeerResponse() {
        return new UpdateBeerResponse();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link ReadBeer }
     * 
     */
    public ReadBeer createReadBeer() {
        return new ReadBeer();
    }

    /**
     * Create an instance of {@link AddUserViewResponse }
     * 
     */
    public AddUserViewResponse createAddUserViewResponse() {
        return new AddUserViewResponse();
    }

    /**
     * Create an instance of {@link ReadUserList }
     * 
     */
    public ReadUserList createReadUserList() {
        return new ReadUserList();
    }

    /**
     * Create an instance of {@link AddBeerToUserResponse }
     * 
     */
    public AddBeerToUserResponse createAddBeerToUserResponse() {
        return new AddBeerToUserResponse();
    }

    /**
     * Create an instance of {@link ReadBeerList }
     * 
     */
    public ReadBeerList createReadBeerList() {
        return new ReadBeerList();
    }

    /**
     * Create an instance of {@link GetBeerRatingUserResponse }
     * 
     */
    public GetBeerRatingUserResponse createGetBeerRatingUserResponse() {
        return new GetBeerRatingUserResponse();
    }

    /**
     * Create an instance of {@link AddBeerToUser }
     * 
     */
    public AddBeerToUser createAddBeerToUser() {
        return new AddBeerToUser();
    }

    /**
     * Create an instance of {@link GetUserRecomResponse }
     * 
     */
    public GetUserRecomResponse createGetUserRecomResponse() {
        return new GetUserRecomResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link RemoveBeerToUserResponse }
     * 
     */
    public RemoveBeerToUserResponse createRemoveBeerToUserResponse() {
        return new RemoveBeerToUserResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link Beer.Rating.Entry }
     * 
     */
    public Beer.Rating.Entry createBeerRatingEntry() {
        return new Beer.Rating.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "updateBeer")
    public JAXBElement<UpdateBeer> createUpdateBeer(UpdateBeer value) {
        return new JAXBElement<UpdateBeer>(_UpdateBeer_QNAME, UpdateBeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserWLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readUserWLResponse")
    public JAXBElement<ReadUserWLResponse> createReadUserWLResponse(ReadUserWLResponse value) {
        return new JAXBElement<ReadUserWLResponse>(_ReadUserWLResponse_QNAME, ReadUserWLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Beer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "Beer")
    public JAXBElement<Beer> createBeer(Beer value) {
        return new JAXBElement<Beer>(_Beer_QNAME, Beer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadBeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readBeerResponse")
    public JAXBElement<ReadBeerResponse> createReadBeerResponse(ReadBeerResponse value) {
        return new JAXBElement<ReadBeerResponse>(_ReadBeerResponse_QNAME, ReadBeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadBeerListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readBeerListResponse")
    public JAXBElement<ReadBeerListResponse> createReadBeerListResponse(ReadBeerListResponse value) {
        return new JAXBElement<ReadBeerListResponse>(_ReadBeerListResponse_QNAME, ReadBeerListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readUser")
    public JAXBElement<ReadUser> createReadUser(ReadUser value) {
        return new JAXBElement<ReadUser>(_ReadUser_QNAME, ReadUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "deleteBeerResponse")
    public JAXBElement<DeleteBeerResponse> createDeleteBeerResponse(DeleteBeerResponse value) {
        return new JAXBElement<DeleteBeerResponse>(_DeleteBeerResponse_QNAME, DeleteBeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserRecom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "getUserRecom")
    public JAXBElement<GetUserRecom> createGetUserRecom(GetUserRecom value) {
        return new JAXBElement<GetUserRecom>(_GetUserRecom_QNAME, GetUserRecom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readUserListResponse")
    public JAXBElement<ReadUserListResponse> createReadUserListResponse(ReadUserListResponse value) {
        return new JAXBElement<ReadUserListResponse>(_ReadUserListResponse_QNAME, ReadUserListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserView }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "addUserView")
    public JAXBElement<AddUserView> createAddUserView(AddUserView value) {
        return new JAXBElement<AddUserView>(_AddUserView_QNAME, AddUserView.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBeerRatingUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "getBeerRatingUser")
    public JAXBElement<GetBeerRatingUser> createGetBeerRatingUser(GetBeerRatingUser value) {
        return new JAXBElement<GetBeerRatingUser>(_GetBeerRatingUser_QNAME, GetBeerRatingUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "deleteBeer")
    public JAXBElement<DeleteBeer> createDeleteBeer(DeleteBeer value) {
        return new JAXBElement<DeleteBeer>(_DeleteBeer_QNAME, DeleteBeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "createBeer")
    public JAXBElement<CreateBeer> createCreateBeer(CreateBeer value) {
        return new JAXBElement<CreateBeer>(_CreateBeer_QNAME, CreateBeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RateUserBeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "rateUserBeerResponse")
    public JAXBElement<RateUserBeerResponse> createRateUserBeerResponse(RateUserBeerResponse value) {
        return new JAXBElement<RateUserBeerResponse>(_RateUserBeerResponse_QNAME, RateUserBeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readUserResponse")
    public JAXBElement<ReadUserResponse> createReadUserResponse(ReadUserResponse value) {
        return new JAXBElement<ReadUserResponse>(_ReadUserResponse_QNAME, ReadUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "createBeerResponse")
    public JAXBElement<CreateBeerResponse> createCreateBeerResponse(CreateBeerResponse value) {
        return new JAXBElement<CreateBeerResponse>(_CreateBeerResponse_QNAME, CreateBeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserWL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readUserWL")
    public JAXBElement<ReadUserWL> createReadUserWL(ReadUserWL value) {
        return new JAXBElement<ReadUserWL>(_ReadUserWL_QNAME, ReadUserWL.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveBeerToUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "removeBeerToUser")
    public JAXBElement<RemoveBeerToUser> createRemoveBeerToUser(RemoveBeerToUser value) {
        return new JAXBElement<RemoveBeerToUser>(_RemoveBeerToUser_QNAME, RemoveBeerToUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBeerRatingUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "getBeerRatingUserResponse")
    public JAXBElement<GetBeerRatingUserResponse> createGetBeerRatingUserResponse(GetBeerRatingUserResponse value) {
        return new JAXBElement<GetBeerRatingUserResponse>(_GetBeerRatingUserResponse_QNAME, GetBeerRatingUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBeerToUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "addBeerToUserResponse")
    public JAXBElement<AddBeerToUserResponse> createAddBeerToUserResponse(AddBeerToUserResponse value) {
        return new JAXBElement<AddBeerToUserResponse>(_AddBeerToUserResponse_QNAME, AddBeerToUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadBeerList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readBeerList")
    public JAXBElement<ReadBeerList> createReadBeerList(ReadBeerList value) {
        return new JAXBElement<ReadBeerList>(_ReadBeerList_QNAME, ReadBeerList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadBeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readBeer")
    public JAXBElement<ReadBeer> createReadBeer(ReadBeer value) {
        return new JAXBElement<ReadBeer>(_ReadBeer_QNAME, ReadBeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserViewResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "addUserViewResponse")
    public JAXBElement<AddUserViewResponse> createAddUserViewResponse(AddUserViewResponse value) {
        return new JAXBElement<AddUserViewResponse>(_AddUserViewResponse_QNAME, AddUserViewResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadUserList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "readUserList")
    public JAXBElement<ReadUserList> createReadUserList(ReadUserList value) {
        return new JAXBElement<ReadUserList>(_ReadUserList_QNAME, ReadUserList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RateUserBeer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "rateUserBeer")
    public JAXBElement<RateUserBeer> createRateUserBeer(RateUserBeer value) {
        return new JAXBElement<RateUserBeer>(_RateUserBeer_QNAME, RateUserBeer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBeerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "updateBeerResponse")
    public JAXBElement<UpdateBeerResponse> createUpdateBeerResponse(UpdateBeerResponse value) {
        return new JAXBElement<UpdateBeerResponse>(_UpdateBeerResponse_QNAME, UpdateBeerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveBeerToUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "removeBeerToUserResponse")
    public JAXBElement<RemoveBeerToUserResponse> createRemoveBeerToUserResponse(RemoveBeerToUserResponse value) {
        return new JAXBElement<RemoveBeerToUserResponse>(_RemoveBeerToUserResponse_QNAME, RemoveBeerToUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "person")
    public JAXBElement<User> createPerson(User value) {
        return new JAXBElement<User>(_Person_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddBeerToUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "addBeerToUser")
    public JAXBElement<AddBeerToUser> createAddBeerToUser(AddBeerToUser value) {
        return new JAXBElement<AddBeerToUser>(_AddBeerToUser_QNAME, AddBeerToUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserRecomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.project.sde/", name = "getUserRecomResponse")
    public JAXBElement<GetUserRecomResponse> createGetUserRecomResponse(GetUserRecomResponse value) {
        return new JAXBElement<GetUserRecomResponse>(_GetUserRecomResponse_QNAME, GetUserRecomResponse.class, null, value);
    }

}
