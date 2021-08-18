package cdm.event.workflow;

import cdm.event.workflow.meta.MessageInformationMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * This class corresponds to the components of the FpML MessageHeader.model.
 * @version ${project.version}
 */
@RosettaClass

public interface MessageInformation extends RosettaModelObject {
	MessageInformation build();
	MessageInformation.MessageInformationBuilder toBuilder();
	
	/**
	 * A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
	 */
	List<? extends FieldWithMetaString> getCopyTo();
	/**
	 * A unique identifier assigned to the message.
	 */
	FieldWithMetaString getMessageId();
	/**
	 * The identifier for the originator of a message instance.
	 */
	FieldWithMetaString getSentBy();
	/**
	 * The identifier(s) for the recipient(s) of a message instance.
	 */
	List<? extends FieldWithMetaString> getSentTo();
	final static MessageInformationMeta metaData = new MessageInformationMeta();
	
	@Override
	default RosettaMetaData<? extends MessageInformation> metaData() {
		return metaData;
	} 
			
	static MessageInformation.MessageInformationBuilder builder() {
		return new MessageInformation.MessageInformationBuilderImpl();
	}
	
	default Class<? extends MessageInformation> getType() {
		return MessageInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("copyTo"), processor, FieldWithMetaString.class, getCopyTo());
		processRosetta(path.newSubPath("messageId"), processor, FieldWithMetaString.class, getMessageId());
		processRosetta(path.newSubPath("sentBy"), processor, FieldWithMetaString.class, getSentBy());
		processRosetta(path.newSubPath("sentTo"), processor, FieldWithMetaString.class, getSentTo());
	}
	
	
	interface MessageInformationBuilder extends MessageInformation, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCopyTo(int _index);
		List<? extends FieldWithMetaStringBuilder> getCopyTo();
		FieldWithMetaStringBuilder getOrCreateMessageId();
		FieldWithMetaStringBuilder getMessageId();
		FieldWithMetaStringBuilder getOrCreateSentBy();
		FieldWithMetaStringBuilder getSentBy();
		FieldWithMetaStringBuilder getOrCreateSentTo(int _index);
		List<? extends FieldWithMetaStringBuilder> getSentTo();
		MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString copyTo);
		MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString copyTo, int _idx);
		MessageInformation.MessageInformationBuilder addCopyToValue(String copyTo);
		MessageInformation.MessageInformationBuilder addCopyToValue(String copyTo, int _idx);
		MessageInformation.MessageInformationBuilder addCopyTo(List<? extends FieldWithMetaString> copyTo);
		MessageInformation.MessageInformationBuilder setCopyTo(List<? extends FieldWithMetaString> copyTo);
		MessageInformation.MessageInformationBuilder addCopyToValue(List<? extends String> copyTo);
		MessageInformation.MessageInformationBuilder setCopyToValue(List<? extends String> copyTo);
		MessageInformation.MessageInformationBuilder setMessageId(FieldWithMetaString messageId);
		MessageInformation.MessageInformationBuilder setMessageIdValue(String messageId);
		MessageInformation.MessageInformationBuilder setSentBy(FieldWithMetaString sentBy);
		MessageInformation.MessageInformationBuilder setSentByValue(String sentBy);
		MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString sentTo);
		MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString sentTo, int _idx);
		MessageInformation.MessageInformationBuilder addSentToValue(String sentTo);
		MessageInformation.MessageInformationBuilder addSentToValue(String sentTo, int _idx);
		MessageInformation.MessageInformationBuilder addSentTo(List<? extends FieldWithMetaString> sentTo);
		MessageInformation.MessageInformationBuilder setSentTo(List<? extends FieldWithMetaString> sentTo);
		MessageInformation.MessageInformationBuilder addSentToValue(List<? extends String> sentTo);
		MessageInformation.MessageInformationBuilder setSentToValue(List<? extends String> sentTo);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("copyTo"), processor, FieldWithMetaStringBuilder.class, getCopyTo());
			processRosetta(path.newSubPath("messageId"), processor, FieldWithMetaStringBuilder.class, getMessageId());
			processRosetta(path.newSubPath("sentBy"), processor, FieldWithMetaStringBuilder.class, getSentBy());
			processRosetta(path.newSubPath("sentTo"), processor, FieldWithMetaStringBuilder.class, getSentTo());
		}
		
	}
	
	//MessageInformation.MessageInformationImpl
	class MessageInformationImpl implements MessageInformation {
		private final List<? extends FieldWithMetaString> copyTo;
		private final FieldWithMetaString messageId;
		private final FieldWithMetaString sentBy;
		private final List<? extends FieldWithMetaString> sentTo;
		
		protected MessageInformationImpl(MessageInformation.MessageInformationBuilder builder) {
			this.copyTo = ofNullable(builder.getCopyTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.messageId = ofNullable(builder.getMessageId()).map(f->f.build()).orElse(null);
			this.sentBy = ofNullable(builder.getSentBy()).map(f->f.build()).orElse(null);
			this.sentTo = ofNullable(builder.getSentTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaString> getCopyTo() {
			return copyTo;
		}
		
		@Override
		public FieldWithMetaString getMessageId() {
			return messageId;
		}
		
		@Override
		public FieldWithMetaString getSentBy() {
			return sentBy;
		}
		
		@Override
		public List<? extends FieldWithMetaString> getSentTo() {
			return sentTo;
		}
		
		@Override
		public MessageInformation build() {
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder toBuilder() {
			MessageInformation.MessageInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageInformation.MessageInformationBuilder builder) {
			ofNullable(getCopyTo()).ifPresent(builder::setCopyTo);
			ofNullable(getMessageId()).ifPresent(builder::setMessageId);
			ofNullable(getSentBy()).ifPresent(builder::setSentBy);
			ofNullable(getSentTo()).ifPresent(builder::setSentTo);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sentTo, _that.getSentTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sentTo != null ? sentTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageInformation {" +
				"copyTo=" + this.copyTo + ", " +
				"messageId=" + this.messageId + ", " +
				"sentBy=" + this.sentBy + ", " +
				"sentTo=" + this.sentTo +
			'}';
		}
	}
	
	//MessageInformation.MessageInformationBuilderImpl
	class MessageInformationBuilderImpl implements MessageInformation.MessageInformationBuilder {
	
		protected List<FieldWithMetaStringBuilder> copyTo = new ArrayList<>();
		protected FieldWithMetaStringBuilder messageId;
		protected FieldWithMetaStringBuilder sentBy;
		protected List<FieldWithMetaStringBuilder> sentTo = new ArrayList<>();
	
		public MessageInformationBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaStringBuilder> getCopyTo() {
			return copyTo;
		}
		
		public FieldWithMetaStringBuilder getOrCreateCopyTo(int _index) {
		
			if (copyTo==null) {
				this.copyTo = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(copyTo, _index, () -> {
						FieldWithMetaStringBuilder newCopyTo = FieldWithMetaString.builder();
						return newCopyTo;
					});
		}
		
		@Override
		public FieldWithMetaStringBuilder getMessageId() {
			return messageId;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateMessageId() {
			FieldWithMetaStringBuilder result;
			if (messageId!=null) {
				result = messageId;
			}
			else {
				result = messageId = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getSentBy() {
			return sentBy;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateSentBy() {
			FieldWithMetaStringBuilder result;
			if (sentBy!=null) {
				result = sentBy;
			}
			else {
				result = sentBy = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends FieldWithMetaStringBuilder> getSentTo() {
			return sentTo;
		}
		
		public FieldWithMetaStringBuilder getOrCreateSentTo(int _index) {
		
			if (sentTo==null) {
				this.sentTo = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(sentTo, _index, () -> {
						FieldWithMetaStringBuilder newSentTo = FieldWithMetaString.builder();
						return newSentTo;
					});
		}
		
	
		@Override
		public MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString copyTo) {
			if (copyTo!=null) this.copyTo.add(copyTo.toBuilder());
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString copyTo, int _idx) {
			getIndex(this.copyTo, _idx, () -> copyTo.toBuilder());
			return this;
		}
		
			@Override
			public MessageInformation.MessageInformationBuilder addCopyToValue(String copyTo) {
				this.getOrCreateCopyTo(-1).setValue(copyTo);
				return this;
			}
			
			@Override
			public MessageInformation.MessageInformationBuilder addCopyToValue(String copyTo, int _idx) {
				this.getOrCreateCopyTo(_idx).setValue(copyTo);
				return this;
			}
		@Override 
		public MessageInformation.MessageInformationBuilder addCopyTo(List<? extends FieldWithMetaString> copyTos) {
			if (copyTos != null) {
				for (FieldWithMetaString toAdd : copyTos) {
					this.copyTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MessageInformation.MessageInformationBuilder setCopyTo(List<? extends FieldWithMetaString> copyTos) {
			if (copyTos == null)  {
				this.copyTo = new ArrayList<>();
			}
			else {
				this.copyTo = copyTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addCopyToValue(List<? extends String> copyTos) {
			if (copyTos != null) {
				for (String toAdd : copyTos) {
					this.addCopyToValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setCopyToValue(List<? extends String> copyTos) {
			this.copyTo.clear();
			if (copyTos!=null) {
				copyTos.forEach(this::addCopyToValue);
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setMessageId(FieldWithMetaString messageId) {
			this.messageId = messageId==null?null:messageId.toBuilder();
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setMessageIdValue(String messageId) {
			this.getOrCreateMessageId().setValue(messageId);
			return this;
		}
		@Override
		public MessageInformation.MessageInformationBuilder setSentBy(FieldWithMetaString sentBy) {
			this.sentBy = sentBy==null?null:sentBy.toBuilder();
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setSentByValue(String sentBy) {
			this.getOrCreateSentBy().setValue(sentBy);
			return this;
		}
		@Override
		public MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString sentTo) {
			if (sentTo!=null) this.sentTo.add(sentTo.toBuilder());
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString sentTo, int _idx) {
			getIndex(this.sentTo, _idx, () -> sentTo.toBuilder());
			return this;
		}
		
			@Override
			public MessageInformation.MessageInformationBuilder addSentToValue(String sentTo) {
				this.getOrCreateSentTo(-1).setValue(sentTo);
				return this;
			}
			
			@Override
			public MessageInformation.MessageInformationBuilder addSentToValue(String sentTo, int _idx) {
				this.getOrCreateSentTo(_idx).setValue(sentTo);
				return this;
			}
		@Override 
		public MessageInformation.MessageInformationBuilder addSentTo(List<? extends FieldWithMetaString> sentTos) {
			if (sentTos != null) {
				for (FieldWithMetaString toAdd : sentTos) {
					this.sentTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MessageInformation.MessageInformationBuilder setSentTo(List<? extends FieldWithMetaString> sentTos) {
			if (sentTos == null)  {
				this.sentTo = new ArrayList<>();
			}
			else {
				this.sentTo = sentTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addSentToValue(List<? extends String> sentTos) {
			if (sentTos != null) {
				for (String toAdd : sentTos) {
					this.addSentToValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setSentToValue(List<? extends String> sentTos) {
			this.sentTo.clear();
			if (sentTos!=null) {
				sentTos.forEach(this::addSentToValue);
			}
			return this;
		}
		
		
		@Override
		public MessageInformation build() {
			return new MessageInformation.MessageInformationImpl(this);
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageInformation.MessageInformationBuilder prune() {
			copyTo = copyTo.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (messageId!=null && !messageId.prune().hasData()) messageId = null;
			if (sentBy!=null && !sentBy.prune().hasData()) sentBy = null;
			sentTo = sentTo.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCopyTo()!=null && !getCopyTo().isEmpty()) return true;
			if (getMessageId()!=null) return true;
			if (getSentBy()!=null) return true;
			if (getSentTo()!=null && !getSentTo().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageInformation.MessageInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageInformation.MessageInformationBuilder o = (MessageInformation.MessageInformationBuilder) other;
			
			merger.mergeRosetta(getCopyTo(), o.getCopyTo(), this::getOrCreateCopyTo);
			merger.mergeRosetta(getMessageId(), o.getMessageId(), this::setMessageId);
			merger.mergeRosetta(getSentBy(), o.getSentBy(), this::setSentBy);
			merger.mergeRosetta(getSentTo(), o.getSentTo(), this::getOrCreateSentTo);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sentTo, _that.getSentTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sentTo != null ? sentTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageInformationBuilder {" +
				"copyTo=" + this.copyTo + ", " +
				"messageId=" + this.messageId + ", " +
				"sentBy=" + this.sentBy + ", " +
				"sentTo=" + this.sentTo +
			'}';
		}
	}
}
