package Business_Logic;


/**
 * the class of tag
 * 
 * @author Bing Guanqi
 * @version 1.0
 */
public class Tag {

	private String tagContent;

	/**
	 * constructor
	 * 
	 * @param tagId
	 *            every tag has it's own unique id
	 * @param tagContent
	 *            tag's content
	 */
	public Tag( String tagContent) {
		
		this.tagContent = tagContent;
	}

	/**
	 * getter of tagId
	 * 
	 * @return id of tag
	 */
	
	/**
	 * getter of tagContent
	 * 
	 * @return content of tag
	 */
	public String getTagContent() {
		return this.tagContent;
	}

	/**
	 * setter of tagId
	 * 
	 * @param tagId
	 *            new id you want to give tag
	 */
	

	/**
	 * setter of tagContent
	 * 
	 * @param tagContent
	 *            new content you want to give tag
	 */
	public void setTagContent(String tagContent) {
		this.tagContent = tagContent;
	}

	/**
	 * connector to connect the database
	 * 
	 * @param dbconnector
	 *            the instance of DBConnector
	 * @throws SQLException
	 */
	
		
	

}
