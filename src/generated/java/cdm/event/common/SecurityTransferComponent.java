package cdm.event.common;

import cdm.base.staticdata.asset.common.Security;
import cdm.event.common.TransferBase.TransferBaseBuilder;
import cdm.event.common.TransferBase.TransferBaseBuilderImpl;
import cdm.event.common.TransferBase.TransferBaseImpl;
import cdm.event.common.meta.SecurityTransferComponentMeta;
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
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityTransferComponent extends TransferBase {
	SecurityTransferComponent build();
	SecurityTransferComponent.SecurityTransferComponentBuilder toBuilder();
	
	/**
	 */
	AssetTransferTypeEnum getAssetTransferType();
	/**
	 * The security transfer breakdown, when the transfer corresponds to a net transfer across several components which breakdown is deemed relevant (e.g. the net security transfer related to several contracts).
	 */
	List<? extends SecurityTransferBreakdown> getBreakdown();
	/**
	 */
	BigDecimal getQuantity();
	/**
	 * The security that is being transfered
	 */
	Security getSecurity();
	/**
	 * The transferee and transferor party information.
	 */
	TransferorTransferee getTransferorTransferee();
	final static SecurityTransferComponentMeta metaData = new SecurityTransferComponentMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityTransferComponent> metaData() {
		return metaData;
	} 
			
	static SecurityTransferComponent.SecurityTransferComponentBuilder builder() {
		return new SecurityTransferComponent.SecurityTransferComponentBuilderImpl();
	}
	
	default Class<? extends SecurityTransferComponent> getType() {
		return SecurityTransferComponent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.common.TransferBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("assetTransferType"), AssetTransferTypeEnum.class, getAssetTransferType(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		
		processRosetta(path.newSubPath("breakdown"), processor, SecurityTransferBreakdown.class, getBreakdown());
		processRosetta(path.newSubPath("security"), processor, Security.class, getSecurity());
		processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.class, getTransferorTransferee());
	}
	
	
	interface SecurityTransferComponentBuilder extends SecurityTransferComponent, TransferBase.TransferBaseBuilder, RosettaModelObjectBuilder {
		SecurityTransferBreakdown.SecurityTransferBreakdownBuilder getOrCreateBreakdown(int _index);
		List<? extends SecurityTransferBreakdown.SecurityTransferBreakdownBuilder> getBreakdown();
		Security.SecurityBuilder getOrCreateSecurity();
		Security.SecurityBuilder getSecurity();
		TransferorTransferee.TransferorTransfereeBuilder getOrCreateTransferorTransferee();
		TransferorTransferee.TransferorTransfereeBuilder getTransferorTransferee();
		SecurityTransferComponent.SecurityTransferComponentBuilder setAssetTransferType(AssetTransferTypeEnum assetTransferType);
		SecurityTransferComponent.SecurityTransferComponentBuilder addBreakdown(SecurityTransferBreakdown breakdown);
		SecurityTransferComponent.SecurityTransferComponentBuilder addBreakdown(SecurityTransferBreakdown breakdown, int _idx);
		SecurityTransferComponent.SecurityTransferComponentBuilder addBreakdown(List<? extends SecurityTransferBreakdown> breakdown);
		SecurityTransferComponent.SecurityTransferComponentBuilder setBreakdown(List<? extends SecurityTransferBreakdown> breakdown);
		SecurityTransferComponent.SecurityTransferComponentBuilder setQuantity(BigDecimal quantity);
		SecurityTransferComponent.SecurityTransferComponentBuilder setSecurity(Security security);
		SecurityTransferComponent.SecurityTransferComponentBuilder setTransferorTransferee(TransferorTransferee transferorTransferee);
		SecurityTransferComponent.SecurityTransferComponentBuilder setIdentifier(FieldWithMetaString identifier);
		SecurityTransferComponent.SecurityTransferComponentBuilder setIdentifierValue(String identifier);
		SecurityTransferComponent.SecurityTransferComponentBuilder setTransferCalculation(TransferCalculation transferCalculation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			TransferBase.TransferBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("assetTransferType"), AssetTransferTypeEnum.class, getAssetTransferType(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			
			processRosetta(path.newSubPath("breakdown"), processor, SecurityTransferBreakdown.SecurityTransferBreakdownBuilder.class, getBreakdown());
			processRosetta(path.newSubPath("security"), processor, Security.SecurityBuilder.class, getSecurity());
			processRosetta(path.newSubPath("transferorTransferee"), processor, TransferorTransferee.TransferorTransfereeBuilder.class, getTransferorTransferee());
		}
		
	}
	
	//SecurityTransferComponent.SecurityTransferComponentImpl
	class SecurityTransferComponentImpl extends TransferBase.TransferBaseImpl implements SecurityTransferComponent {
		private final AssetTransferTypeEnum assetTransferType;
		private final List<? extends SecurityTransferBreakdown> breakdown;
		private final BigDecimal quantity;
		private final Security security;
		private final TransferorTransferee transferorTransferee;
		
		protected SecurityTransferComponentImpl(SecurityTransferComponent.SecurityTransferComponentBuilder builder) {
			super(builder);
			this.assetTransferType = builder.getAssetTransferType();
			this.breakdown = ofNullable(builder.getBreakdown()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.quantity = builder.getQuantity();
			this.security = ofNullable(builder.getSecurity()).map(f->f.build()).orElse(null);
			this.transferorTransferee = ofNullable(builder.getTransferorTransferee()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AssetTransferTypeEnum getAssetTransferType() {
			return assetTransferType;
		}
		
		@Override
		public List<? extends SecurityTransferBreakdown> getBreakdown() {
			return breakdown;
		}
		
		@Override
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public Security getSecurity() {
			return security;
		}
		
		@Override
		public TransferorTransferee getTransferorTransferee() {
			return transferorTransferee;
		}
		
		@Override
		public SecurityTransferComponent build() {
			return this;
		}
		
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder toBuilder() {
			SecurityTransferComponent.SecurityTransferComponentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityTransferComponent.SecurityTransferComponentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAssetTransferType()).ifPresent(builder::setAssetTransferType);
			ofNullable(getBreakdown()).ifPresent(builder::setBreakdown);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getSecurity()).ifPresent(builder::setSecurity);
			ofNullable(getTransferorTransferee()).ifPresent(builder::setTransferorTransferee);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecurityTransferComponent _that = getType().cast(o);
		
			if (!Objects.equals(assetTransferType, _that.getAssetTransferType())) return false;
			if (!ListEquals.listEquals(breakdown, _that.getBreakdown())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(transferorTransferee, _that.getTransferorTransferee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (assetTransferType != null ? assetTransferType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakdown != null ? breakdown.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityTransferComponent {" +
				"assetTransferType=" + this.assetTransferType + ", " +
				"breakdown=" + this.breakdown + ", " +
				"quantity=" + this.quantity + ", " +
				"security=" + this.security + ", " +
				"transferorTransferee=" + this.transferorTransferee +
			'}' + " " + super.toString();
		}
	}
	
	//SecurityTransferComponent.SecurityTransferComponentBuilderImpl
	class SecurityTransferComponentBuilderImpl extends TransferBase.TransferBaseBuilderImpl  implements SecurityTransferComponent.SecurityTransferComponentBuilder {
	
		protected AssetTransferTypeEnum assetTransferType;
		protected List<SecurityTransferBreakdown.SecurityTransferBreakdownBuilder> breakdown = new ArrayList<>();
		protected BigDecimal quantity;
		protected Security.SecurityBuilder security;
		protected TransferorTransferee.TransferorTransfereeBuilder transferorTransferee;
	
		public SecurityTransferComponentBuilderImpl() {
		}
	
		@Override
		public AssetTransferTypeEnum getAssetTransferType() {
			return assetTransferType;
		}
		
		@Override
		public List<? extends SecurityTransferBreakdown.SecurityTransferBreakdownBuilder> getBreakdown() {
			return breakdown;
		}
		
		public SecurityTransferBreakdown.SecurityTransferBreakdownBuilder getOrCreateBreakdown(int _index) {
		
			if (breakdown==null) {
				this.breakdown = new ArrayList<>();
			}
			SecurityTransferBreakdown.SecurityTransferBreakdownBuilder result;
			return getIndex(breakdown, _index, () -> {
						SecurityTransferBreakdown.SecurityTransferBreakdownBuilder newBreakdown = SecurityTransferBreakdown.builder();
						return newBreakdown;
					});
		}
		
		@Override
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		public Security.SecurityBuilder getSecurity() {
			return security;
		}
		
		@Override
		public Security.SecurityBuilder getOrCreateSecurity() {
			Security.SecurityBuilder result;
			if (security!=null) {
				result = security;
			}
			else {
				result = security = Security.builder();
			}
			
			return result;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder getTransferorTransferee() {
			return transferorTransferee;
		}
		
		@Override
		public TransferorTransferee.TransferorTransfereeBuilder getOrCreateTransferorTransferee() {
			TransferorTransferee.TransferorTransfereeBuilder result;
			if (transferorTransferee!=null) {
				result = transferorTransferee;
			}
			else {
				result = transferorTransferee = TransferorTransferee.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder setAssetTransferType(AssetTransferTypeEnum assetTransferType) {
			this.assetTransferType = assetTransferType==null?null:assetTransferType;
			return this;
		}
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder addBreakdown(SecurityTransferBreakdown breakdown) {
			if (breakdown!=null) this.breakdown.add(breakdown.toBuilder());
			return this;
		}
		
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder addBreakdown(SecurityTransferBreakdown breakdown, int _idx) {
			getIndex(this.breakdown, _idx, () -> breakdown.toBuilder());
			return this;
		}
		@Override 
		public SecurityTransferComponent.SecurityTransferComponentBuilder addBreakdown(List<? extends SecurityTransferBreakdown> breakdowns) {
			if (breakdowns != null) {
				for (SecurityTransferBreakdown toAdd : breakdowns) {
					this.breakdown.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SecurityTransferComponent.SecurityTransferComponentBuilder setBreakdown(List<? extends SecurityTransferBreakdown> breakdowns) {
			if (breakdowns == null)  {
				this.breakdown = new ArrayList<>();
			}
			else {
				this.breakdown = breakdowns.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder setSecurity(Security security) {
			this.security = security==null?null:security.toBuilder();
			return this;
		}
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder setTransferorTransferee(TransferorTransferee transferorTransferee) {
			this.transferorTransferee = transferorTransferee==null?null:transferorTransferee.toBuilder();
			return this;
		}
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder setTransferCalculation(TransferCalculation transferCalculation) {
			this.transferCalculation = transferCalculation==null?null:transferCalculation.toBuilder();
			return this;
		}
		
		@Override
		public SecurityTransferComponent build() {
			return new SecurityTransferComponent.SecurityTransferComponentImpl(this);
		}
		
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder prune() {
			super.prune();
			breakdown = breakdown.stream().filter(b->b!=null).<SecurityTransferBreakdown.SecurityTransferBreakdownBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (security!=null && !security.prune().hasData()) security = null;
			if (transferorTransferee!=null && !transferorTransferee.prune().hasData()) transferorTransferee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAssetTransferType()!=null) return true;
			if (getBreakdown()!=null && getBreakdown().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getQuantity()!=null) return true;
			if (getSecurity()!=null && getSecurity().hasData()) return true;
			if (getTransferorTransferee()!=null && getTransferorTransferee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityTransferComponent.SecurityTransferComponentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SecurityTransferComponent.SecurityTransferComponentBuilder o = (SecurityTransferComponent.SecurityTransferComponentBuilder) other;
			
			merger.mergeRosetta(getBreakdown(), o.getBreakdown(), this::getOrCreateBreakdown);
			merger.mergeRosetta(getSecurity(), o.getSecurity(), this::setSecurity);
			merger.mergeRosetta(getTransferorTransferee(), o.getTransferorTransferee(), this::setTransferorTransferee);
			
			merger.mergeBasic(getAssetTransferType(), o.getAssetTransferType(), this::setAssetTransferType);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecurityTransferComponent _that = getType().cast(o);
		
			if (!Objects.equals(assetTransferType, _that.getAssetTransferType())) return false;
			if (!ListEquals.listEquals(breakdown, _that.getBreakdown())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(transferorTransferee, _that.getTransferorTransferee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (assetTransferType != null ? assetTransferType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakdown != null ? breakdown.hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (transferorTransferee != null ? transferorTransferee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityTransferComponentBuilder {" +
				"assetTransferType=" + this.assetTransferType + ", " +
				"breakdown=" + this.breakdown + ", " +
				"quantity=" + this.quantity + ", " +
				"security=" + this.security + ", " +
				"transferorTransferee=" + this.transferorTransferee +
			'}' + " " + super.toString();
		}
	}
}
