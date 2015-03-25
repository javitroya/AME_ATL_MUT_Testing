/**
 */
package ATL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ATL.Library#getHelpers <em>Helpers</em>}</li>
 * </ul>
 * </p>
 *
 * @see ATL.ATLPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends Unit {
	/**
	 * Returns the value of the '<em><b>Helpers</b></em>' reference list.
	 * The list contents are of type {@link ATL.Helper}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helpers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helpers</em>' reference list.
	 * @see ATL.ATLPackage#getLibrary_Helpers()
	 * @model
	 * @generated
	 */
	EList<Helper> getHelpers();

} // Library
